/*
 * HA-JDBC: High-Availability JDBC
 * Copyright (c) 2004-2009 Paul Ferraro
 * 
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation; either version 2.1 of the License, or (at your 
 * option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
 * for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, 
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * Contact: ferraro@users.sourceforge.net
 */
package net.sf.hajdbc.sql;

import java.lang.reflect.InvocationHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import net.sf.hajdbc.Database;
import net.sf.hajdbc.DatabaseCluster;

/**
 * @author paul
 *
 */
public class NClobInvocationStrategy<Z, D extends Database<Z>, P> extends LocatorInvocationStrategy<Z, D, P, java.sql.NClob>
{
	public NClobInvocationStrategy(DatabaseCluster<Z, D> cluster, P parent, Connection connection) throws SQLException
	{
		super(cluster, parent, java.sql.NClob.class, connection);
	}

	/**
	 * {@inheritDoc}
	 * @see net.sf.hajdbc.sql.LocatorInvocationStrategy#createInvocationHandler(java.lang.Object, net.sf.hajdbc.sql.SQLProxy, net.sf.hajdbc.sql.Invoker, java.util.Map, boolean)
	 */
	@Override
	protected InvocationHandler createInvocationHandler(P parent, SQLProxy<Z, D, P, SQLException> proxy, Invoker<Z, D, P, java.sql.NClob, SQLException> invoker, Map<D, java.sql.NClob> objectMap, boolean updateCopy) throws SQLException
	{
		return new NClobInvocationHandler<Z, D, P>(parent, proxy, invoker, objectMap, updateCopy);
	}
}