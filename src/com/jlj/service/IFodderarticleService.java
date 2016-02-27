package com.jlj.service;

import java.util.List;

import com.jlj.model.Fodderarticle;

public interface IFodderarticleService {

	public abstract void add(Fodderarticle fodderarticle) throws Exception;

	public abstract void delete(Fodderarticle fodderarticle);

	public abstract void deleteById(int id);

	public abstract void update(Fodderarticle fodderarticle);

	public abstract List<Fodderarticle> getFodderarticles();

	public abstract Fodderarticle loadById(int id);

	public abstract List<Fodderarticle> queryFodderarticlesByFodderid(
			int fodderid);

}