package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.CustomerBean;

public class CustomerDAO extends GenericDAO<CustomerBean> {

	public CustomerDAO(ConnectionPool connectionPool, String tableName)
			throws DAOException {
		super(CustomerBean.class, tableName, connectionPool);
	}

	public CustomerBean getCustomerByUsername(String username)
			throws RollbackException {
		CustomerBean[] customer = match(MatchArg.equals("username", username));
		if (customer.length != 1) {
			System.out.println("not correct number of customers");
		}
		return customer[0];
	}

}
