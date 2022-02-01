//package com.example.demo.utility;
//
//import javax.transaction.Synchronization;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Transaction;
//import org.hibernate.resource.transaction.spi.TransactionStatus;
//
//public class T_Transaction implements Transaction {
//	T_Transaction transaction = new T_Transaction();
//	@Override
//	public void begin() {
//		transaction.begin();
//	}
//
//	@Override
//	public void commit() {
//		transaction.commit();
//	}
//
//	@Override
//	public void rollback() {
//		transaction.rollback();
//	}
//
//	@Override
//	public void setRollbackOnly() {
//		transaction.setRollbackOnly();
//	}
//
//	@Override
//	public boolean getRollbackOnly() {
//		if(transaction.getStatus() == TransactionStatus.ROLLED_BACK)
//			return true;
//		return false;
//	}
//
//	@Override
//	public boolean isActive() {
//		if(transaction.getStatus() == TransactionStatus.ACTIVE)
//			return true;
//		return false;
//	}
//
//	@Override
//	public TransactionStatus getStatus() {
//		return transaction.getStatus();
//	}
//
//	@Override
//	public void registerSynchronization(Synchronization synchronization) throws HibernateException {
//		transaction.registerSynchronization(synchronization);
//	}
//
//	@Override
//	public void setTimeout(int seconds) {
//		transaction.setTimeout(seconds);
//	}
//
//	@Override
//	public int getTimeout() {
//		return transaction.getTimeout();
//	}
//}
