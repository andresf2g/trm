package co.gov.superfinanciera.trm.service;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TCRMServicesInterfaceProxy;
import co.com.sc.nexura.superfinanciera.action.generic.services.trm.action.TcrmResponse;

public final class TrmServiceConsumer {
	
	private TrmServiceConsumer() {
	}
	
	/**
	 * TCRM query value format
	 */
	private static final String VALUE_QUERY_FORMAT = "#0.00";

	/**
	 * Web Service end point
	 */
	private static final String WEB_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";

	public static String obtenerTrm() throws RemoteException {
		return obtenerTrm(null);
	}

	public static String obtenerTrm(Date fecha) throws RemoteException {
		DecimalFormat decimalFormat = new DecimalFormat(VALUE_QUERY_FORMAT);

		TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(WEB_SERVICE_URL);

		Calendar calendar = null;
		if (fecha != null) {
			calendar = Calendar.getInstance();
			calendar.setTime(fecha);
		}

		TcrmResponse tcrmResponse = proxy.queryTCRM(calendar);

		return decimalFormat.format(tcrmResponse.getValue());
	}
}
