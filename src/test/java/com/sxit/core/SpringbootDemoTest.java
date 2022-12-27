package com.sxit.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxit.entity.AuditConfig;
import com.sxit.entity.PgcAccount;
import com.sxit.mapper.PgcAccountMapper;
import com.sxit.service.AuditConfigService;

import redis.clients.jedis.Jedis;

/**
 * 测试类必须要与启动类相同目录（如：com.sxit.core），否则测试时会报错
 */
@SpringBootTest
public class SpringbootDemoTest {

	@Resource
	PgcAccountMapper mapper;
	@Resource
	AuditConfigService auditService;
	@SuppressWarnings("rawtypes")
	@Resource
	RedisTemplate redisTemplate;
	@Resource
	DataSource dataSource;

	@Test
	void testDataSource() {
		Class<? extends DataSource> class1 = dataSource.getClass();
		System.out.println(class1);
	}

	@Test
	void test() {
//		IPage<PgcAccount> page = new Page<PgcAccount>(1, 10);
//		page = mapper.selectList((Page<PgcAccount>) page);
//		System.out.println(JSONObject.toJSONString(page));
		PgcAccount a = new PgcAccount();
		a.setCity("沈阳");
		PgcAccount e = new PgcAccount();
		e.setId(2);
		List<PgcAccount> b = new ArrayList<PgcAccount>();
		b.add(a);
		b.add(e);
		System.out.println("account:" + b);
	}

	@Test
	void testAuditConfig() {
		List<AuditConfig> list = auditService.list();
		// 将实体类转成JSON字符串，同时将实体类中的java.sql.Timestamp类型时间格式化
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		System.out.println(JSONObject.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteDateUseDateFormat));
	}

	@Test
	void testInsertAuditConfig() {
		AuditConfig auditConfig = new AuditConfig();
		auditConfig.setCityNo("240");
		auditConfig.setSaveTime(new Timestamp(System.currentTimeMillis()));
		boolean save = auditService.save(auditConfig);
		System.out.println("==============查询结果：" + save);
	}

	@Test
	void testPage() {
		IPage<PgcAccount> page = new Page<PgcAccount>(1, 10);
		page = mapper.selectByParam(new Page<PgcAccount>(), 150);
		System.out.println("===============查询结果：" + page.getRecords().size() + "个");
		System.out.println("===============查询结果：" + JSONObject.toJSONString(page.getRecords()));
	}

	/**
	 * 获取短信验证码
	 */
	@Test
	void getCode() {
		// 前台获取的手机号
		String phone = "13694198150";
		// 设置每天发送次数
		int maxNum = 3;
		// 连接redis,ip+port
		Jedis jedis = new Jedis("211.137.43.228", 6379);
//		ValueOperations opsForValue = redisTemplate.opsForValue();
		// 发送次数key
		String countKey = phone + "_count";
//		String string = (String) opsForValue.get(countKey);
		// 获取历史发送次数
		String phoneCount = jedis.get(countKey);
		if (phoneCount == null) {// 当天没发送过验证码
			// 设置发送次数（第一次），且设置失效时间：一天
			jedis.setex(countKey, 24 * 60 * 60, "1");
//			opsForValue.set(countKey, "1", 24 * 60 * 60, TimeUnit.SECONDS);//会自动关闭连接
		} else {// 当天发送过
			// 判断是否超过每天的发送限制
			if (Integer.valueOf(phoneCount) >= maxNum) {
				System.err.println("每天发送短信超过次数了");
				jedis.close();
			} else {
				jedis.incr(countKey);
			}
		}
		// 获取验证码
		String code = "1234";
		String codeKey = phone + "_code";
		// 设置5分钟有效
		jedis.setex(codeKey, 60 * 5, code);
		jedis.close();
		// 发送验证码给手机

		System.out.println("验证码：" + code);
	}

	/**
	 * 校验验证码
	 */
	@Test
	void checkCode() {
		// 获取前台手机号
		String phone = "13694198150";
		// 获取前台验证码
		String code = "123456";
		// 从redis中获取验证码
		String codeKey = phone + "_code";
		Jedis jedis = new Jedis("211.137.43.228", 6379);
		String redisCode = jedis.get(codeKey);
		jedis.close();
		if (redisCode == null) {
			System.out.println("验证码已失效");
		} else if (!code.equals(redisCode)) {
			System.out.println("验证码不正确");
		} else {
			System.out.println("验证成功");
		}
	}
}
