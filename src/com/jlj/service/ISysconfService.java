package com.jlj.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jlj.model.Sysconf;

public interface ISysconfService {

	//添加对象
	public abstract void add(Sysconf sysconf) throws Exception;

	//删除对象
	public abstract void delete(Sysconf sysconf);

	//删除某个id的对象
	public abstract void deleteById(int id);

	//修改对象
	public abstract void update(Sysconf sysconf);

	//获取所有对象
	public abstract List<Sysconf> getSysconfs();

	//加载一个id的对象
	public abstract Sysconf loadById(int id);

	//后台管理-页数获取
	public abstract int getPageCount(int con, String convalue, int size);

	//后台管理-获取总记录数
	public abstract int getTotalCount(int con, String convalue);

	//后台管理-获取符合条件的记录
	public abstract List<Sysconf> queryList(int con, String convalue, int page,
			int size);

	/**
	 * 获取apk版本号
	 * @return
	 */
	@GET
	@Path("/apkversion")
	@Produces(MediaType.APPLICATION_JSON)
	public abstract String getApkVersion();
}