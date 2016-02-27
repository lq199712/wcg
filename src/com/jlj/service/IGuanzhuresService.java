package com.jlj.service;

import java.util.List;

import com.jlj.model.Guanzhures;

public interface IGuanzhuresService {

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#add(com.jlj.model.Guanzhures)
	 */
	public abstract void add(Guanzhures guanzhures) throws Exception;

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#delete(com.jlj.model.Guanzhures)
	 */
	public abstract void delete(Guanzhures guanzhures);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#deleteById(int)
	 */
	public abstract void deleteById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#update(com.jlj.model.Guanzhures)
	 */
	public abstract void update(Guanzhures guanzhures);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getGuanzhuress()
	 */
	public abstract List<Guanzhures> getGuanzhuress();

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#loadById(int)
	 */
	public abstract Guanzhures loadById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getPageCount(int, java.lang.String, int, int, int)
	 */
	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getTotalCount(int, java.lang.String, int, int)
	 */
	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#queryList(int, java.lang.String, int, int, int, int)
	 */
	public abstract List<Guanzhures> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Guanzhures> queryListByPublicAccount(
			String publicaccount);


}