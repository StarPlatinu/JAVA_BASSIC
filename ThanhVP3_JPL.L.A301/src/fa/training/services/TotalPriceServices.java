package fa.training.services;

import java.sql.SQLException;

import fa.training.dao.TotalPriceDao;
import fa.training.daoimpl.TotalPriceImpl;
import fa.training.entities.Customer;
import fa.training.entities.TotalPrice;

public class TotalPriceServices {
    TotalPriceDao totalPriceDao ;
    
    public TotalPriceServices() {
    	totalPriceDao = new TotalPriceImpl();
	}
    
    

}
