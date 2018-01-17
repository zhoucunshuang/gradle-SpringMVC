
package com.zcs.demo.account.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zcs.account.domain.Account;
import com.zcs.account.service.AccountService;
import com.zcs.demo.account.dao.AccountMapper;

/**
 * 报销科目实现类
 * @see		
 * @author  zaiz@woyitech.com
 * @date	2017年6月19日 20:28:51
 * @version	 
 */
@Service("accountService")
public class AccountServiceImp implements AccountService {

	/**
	 * accountMapper
	 */
   @Resource
   private AccountMapper accountMapper;
   
	@Override
	public List<Account> getAllAcounts(String companyId) throws Exception {
		return accountMapper.getAllAcounts(companyId);
	}

	@Override
	public JSONArray getAllAcountList(String companyId) throws Exception {
		//查询所有的报销科目
				List<Account> allAccountList = null;
				JSONObject node = null;
				JSONArray nodes = new JSONArray();
				try {
					allAccountList = getAllAcounts(companyId);
					for (Account account : allAccountList) {
						node = new JSONObject();
						node.put("id", account.getId());
						node.put("pId", account.getParentid());
						if (account.getParentid() != null && !account.getParentid().equals("0")) {
							node.put("name", account.getCode()+"-"+account.getName());
						}else {
							node.put("name", account.getName());
						}
						node.put("open", false);
						nodes.add(node);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return nodes;
				
	}

	@Override
	public Account selectByPrimaryKey(String id) throws Exception {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteAccountByIds(String[] ids) throws Exception {
		return accountMapper.deleteAccountByIds(ids);
	}

	@Override
	public int insert(Account record) throws Exception {
		return accountMapper.insert(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Account record) throws Exception {
		return accountMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<Account> selectByParentId(Account account) throws Exception {
		return accountMapper.selectByParentId(account);
	}
	@Override
	public List<Account> selectChildsByParentId(Account account) throws Exception {
		return accountMapper.selectChildsByParentId(account);
	}

	@Override
	public List<Account> getChildrens(Account account){
		List<Account> childrens = new ArrayList<Account>();
		try {
			//根据上一级科目分类id,获取直接下级分类
			List<Account> accounts = accountMapper.selectByParentId(account);
			for (Account acc:accounts){
				List<Account> list = this.getChildrens(acc);
				childrens.addAll(list);
				childrens.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return childrens;
	}

	@Override
	public List<Account> selectByName(Account account) {
		return accountMapper.selectByName(account);
	}
}

