package com.sxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxit.entity.PgcAccount;
import com.sxit.mapper.PgcAccountMapper;
import com.sxit.service.IPgcAccountService;


/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author fuguocheng
 * @since 2017-05-27
 */
@Service
public class PgcAccountServiceImpl extends ServiceImpl<PgcAccountMapper, PgcAccount> implements IPgcAccountService {

	@Resource
    PgcAccountMapper mapper;

	@Override
	public IPage<PgcAccount> selectList(Page<PgcAccount> page) {
//		List<PgcAccount> list = mapper.selectList(page);
//		page.setRecords(list);
//		return page;
		return mapper.selectList(page);
	}

}
