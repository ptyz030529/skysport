package com.skysport.core.action;
import com.skysport.core.bean.DataTablesInfo;
import com.skysport.core.constant.CommonConstant;
import com.skysport.core.instance.DictionaryInfo;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 此类描述的是：
 * 
 * @author: zhangjh
 * @version: 2015年4月30日 下午4:34:05
 */
public class CommonAction<K, V, T> {

	/**
	 * 
	 * 此方法描述的是：返回datatables需要的数据
	 * 
	 * @author: zhangjh
	 * @version: 2015年4月30日 下午4:34:11
	 */
	public <K, V> Map<K, V> buildSearchJsonMap(List<T> results, int recordsTotal, int recordsFiltered, int draw) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("data", results);
		info.put("recordsTotal", recordsTotal);
		info.put("recordsFiltered", recordsFiltered);
		info.put("draw", draw);
		return (Map<K, V>) info;
	}

	/**
	 * 将页面的分页信息传到后台
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @return
	 */
	protected DataTablesInfo convertToDataTableQrInfo(HttpServletRequest request) {
		DataTablesInfo dataTablesInfo = new DataTablesInfo();
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));
		int draw = Integer.parseInt(request.getParameter("draw"));
		String orderColumn = request.getParameter("order[0][column]");
		String pageColumnName = request.getParameter("columns[" + orderColumn + "][data]");
		String tableColumnName = getRealTableColumnName(pageColumnName);
		String orderDir = request.getParameter("order[0][dir]");
		String searchValue = request.getParameter("search[value]");

		dataTablesInfo.setStart(start);
		dataTablesInfo.setLength(length);
		dataTablesInfo.setOrderColumn(tableColumnName);
		dataTablesInfo.setOrderDir(orderDir);
		dataTablesInfo.setSearchValue(searchValue);
		dataTablesInfo.setStart(start);
		dataTablesInfo.setDraw(draw);
		return dataTablesInfo;
	}

	/**
	 * 
	 * @param pageColumnName
	 * @return
	 */
	private String getRealTableColumnName(String pageColumnName) {
		String tableColumnName = DictionaryInfo.SINGLETONE.getDictionaryValue(CommonConstant.SP_TABLE, pageColumnName);
		return tableColumnName;
	}

}
