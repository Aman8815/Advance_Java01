package com.rays.model;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.MarksheetBean;
import com.rays.bean.StudentBean;

public class TestModel {
	public static void main(String[] args) throws SQLException, Exception {
   MarksheetModel model = new MarksheetModel();
   MarksheetBean bean = new MarksheetBean();
   
     model.Delete(1);

}
}