package com.sxit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxit.entity.PgcAccount;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author fuguocheng
 * @since 2017-07-03
 */
public interface IPgcAccountService extends IService<PgcAccount> {

	IPage<PgcAccount> selectList(Page<PgcAccount> page);

}
