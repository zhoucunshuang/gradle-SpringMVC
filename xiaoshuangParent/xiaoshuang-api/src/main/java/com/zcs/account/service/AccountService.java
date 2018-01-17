/**
 * @单位名称：合肥斡亿信息科技有限公司
 * @Copyright (c) 2017 All Rights Reserved.
 * @系统名称：应用中心平台系统
 * @工程名称：ydzw-api
 * @文件名称: AccountService.java
 * @类路径: com.woyi.ydzw.account.service
 */

package com.zcs.account.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.zcs.account.domain.Account;

/**
 * 报销科目接口
 * @see		
 * @author  huangchaoyang
 * @date	2017年5月3日 上午9:31:45
 * @version	 
 * @desc    TODO
 */
public interface AccountService {

	/**
	 * 查询所有报销科目
	 * @return list
	 */
	List<Account> getAllAcounts(String companyId) throws Exception;
	/**
	 * 根据id进行更新
	 * @return Account
	 */
	Account selectByPrimaryKey(String id) throws Exception;
	/**
	 * 根据id进行删除
	 * @return int
	 */
	int  deleteAccountByIds(String[] ids) throws Exception;
	/**
	 * 添加信息
	 * @return int
	 */
	int insert(Account record) throws Exception;
	/**
	 * 根据record更新
	 * @return int
	 */
	int updateByPrimaryKeySelective(Account record) throws Exception;
	/**
	 * 查询报销科目组织树
	 * @return JSONArray
	 * @throws Exception
	 */
	JSONArray getAllAcountList(String companyId) throws Exception;
     
	/**
	 * 根据parentid查询报销科目
	 * @return list
	 * @throws Exception
	 */
	List<Account> selectByParentId(Account account) throws Exception;
	
	/**
	 * 根据parentid查询报销科目
	 * @return list
	 * @throws Exception
	 */
	List<Account> selectChildsByParentId(Account account) throws Exception;
	 
	
	/**查询子级科目
	 * @return List<Account>
	 */
	List<Account> getChildrens(Account account);
	/**  
	* 根据名称查询出科目
	* @return   List<Account>
	* @throws 
	*/
	List<Account> selectByName(Account account);
}

