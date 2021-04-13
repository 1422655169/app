package com.zzx.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzx.model.MxBean;
import com.zzx.util.DBTool;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelImportServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	         //请求发送都是utf-8
		     request.setCharacterEncoding("UTF-8");
	    	 response.setCharacterEncoding("UTF-8");
	         //文件路径
	     	List<MxBean> list = parseExcel("C:\\个人明细.xls");
	    	
			for (int i = 0; i < list.size(); i++) {

				Connection conn = null;
				PreparedStatement ps = null;
				DBTool dbt = new DBTool();
				try {
					conn = dbt.getConnection();
					String sql = "insert into t_yw_mx(xh,jyrq,yelx,bz,crje,zqje,zhye,dfzh,dfxm,dfkhh,fy,zy ) values('"
							+ list.get(i).getXh()
							+ "', '"
							+ list.get(i).getJyrq()
							+ "', '"
							+ list.get(i).getYelx()
							+ "', '"
							+ list.get(i).getBz()
							+ "', '"
							+ list.get(i).getCrje()
							+ "', '"
							+ list.get(i).getZqje()
							+ "', '"
							+ list.get(i).getZhye()
							+ "', '"
							+ list.get(i).getDfzh()
							+ "', '"
							+ list.get(i).getDfxm()
							+ "', '"
							+ list.get(i).getDfkhh()
							+ "', '"
							+ list.get(i).getFy()
							+ "', '"
							+ list.get(i).getZy()+ "')";
					System.out.println(sql);
					ps = conn.prepareStatement(sql);
					ps.execute();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		     request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
	
	// 解析Excel,读取内容,path Excel路径
	public static List<MxBean> parseExcel(String path) {
		List<MxBean> list = new ArrayList<MxBean>();
		File file = null;
		InputStream input = null;
		if (path != null && path.length() > 7) {
			// 判断文件是否是Excel(2003、2007)
			String suffix = path.substring(path.lastIndexOf("."), path.length());
			file = new File(path);
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("未找到指定的文件！");
			}
			// Excel2003
			if (".xls".equals(suffix)) {
				POIFSFileSystem fileSystem = null;
				// 工作簿
				HSSFWorkbook workBook = null;
				try {
					fileSystem = new POIFSFileSystem(input);
					workBook = new HSSFWorkbook(fileSystem);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 获取第一个工作簿
				HSSFSheet sheet = workBook.getSheetAt(0);
				list = getContent((Sheet) sheet);
				// Excel2007
			} else if (".xlsx".equals(suffix)) {
				XSSFWorkbook workBook = null;
				try {
					workBook = new XSSFWorkbook(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 获取第一个工作簿
				XSSFSheet sheet = workBook.getSheetAt(0);
				list = getContent(sheet);
			}
		} else {
			System.out.println("非法的文件路径!");
		}
		return list;
	}

	// 获取Excel内容
	public static List<MxBean> getContent(Sheet sheet) {
		List<MxBean> list = new ArrayList<MxBean>();
		// Excel数据总行数
		int rowCount = sheet.getPhysicalNumberOfRows();
		// 遍历数据行，略过标题行，从第二行开始
		for (int i = 1; i < rowCount; i++) {
			MxBean mx = new MxBean();
			Row row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();
			// 遍历行单元格
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				switch (j) {
				case 0:
					// 根据cell中的类型来输出数据
					//if(cell.getCellType() != Cell.CELL_TYPE_BLANK){
					
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							mx.setXh(cell.getStringCellValue());
						}
					//}
					break;
				case 1:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setJyrq(cell.getStringCellValue());
					}
					break;
				case 2:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setYelx(cell.getStringCellValue());
					}
					break;
				case 3:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setBz(cell.getStringCellValue());
					}
					break;
					
				case 4:
					if(cell!=null && !"".equals(cell)){
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							mx.setCrje(cell.getStringCellValue());
						}
					}else {
						mx.setCrje("");
					}
					break;
				case 5:
					if(cell!=null && !"".equals(cell)){
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							mx.setZqje(cell.getStringCellValue());
						}
					}else{
						mx.setZqje("");
					}
					break;
				case 6:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setZhye(cell.getStringCellValue());
					}
					break;
				case 7:
					if(cell!=null && !"".equals(cell)){
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							
							mx.setDfzh(cell.getStringCellValue());
						}
					}else {
						mx.setDfzh("");
					}
					break;
				case 8:
					if(cell!=null && !"".equals(cell)){
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							
							mx.setDfxm(cell.getStringCellValue());
						}
					}else {
						mx.setDfxm("");
					}
					break;
				case 9:
					
					if(cell!=null && !"".equals(cell)){
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							mx.setDfkhh(cell.getStringCellValue());
						}
					}else {
						mx.setDfkhh("");
					}
					
					break;
				case 10:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setFy(cell.getStringCellValue());
					}
					break;
				case 11:
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						mx.setZy(cell.getStringCellValue());
					}
					break;
					
				}
			}
			list.add(mx);
		}
		
		return list;
	}
	

}
