package com.sxit.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxit.entity.PgcAccount;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author fuguocheng
 * @since 2017-07-03
 */
public interface PgcAccountMapper extends BaseMapper<PgcAccount> {

//	List<PgcAccount> selectList(Page<PgcAccount> page);

	IPage<PgcAccount> selectList(Page<PgcAccount> page);

	IPage<PgcAccount> selectByParam(Page<PgcAccount> page, @Param("id") int i);

}