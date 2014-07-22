package com.seaway.liufuya.mvc.crm.memberlevel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.seaway.liufuya.mvc.crm.memberlevel.dao.MemberLevelDao;
import com.seaway.liufuya.mvc.crm.memberlevel.pojo.MemberLevel;
import com.seaway.liufuya.mvc.crm.memberlevel.pojo.MemberLevelBean;
import com.seaway.liufuya.common.util.DateUtil;

/**
 * 服务层
 * 
 * @author lililiu
 * 
 */
public class MemberLevelService {
	// 查询会员等级数据的数据库对象
	private MemberLevelDao memberLevelManager = null;

	public MemberLevelService() {
		// TODO Auto-generated constructor stub
	}

	public MemberLevelService(MemberLevelDao memberLevelManager) {
		this.memberLevelManager = memberLevelManager;
	}

	/**
	 * 分页从数据库获取数据
	 * 
	 * @param startIndex
	 *            开始记录索引
	 * @param pageRows
	 *            每页显示条数
	 * @return
	 */
	public List<MemberLevelBean> getMemberLevelBean() {
		// 查询所有等级数据，目前不分页 ,第二个参数 rows =0
		List<MemberLevel> levellist = this.memberLevelManager
				.getAllMemberLevelPageList(0, 0);

		List<MemberLevelBean> users = new ArrayList<MemberLevelBean>();

		for (MemberLevel level : levellist) {
			MemberLevelBean bean = new MemberLevelBean();
			bean.setLevelName(level.getLevelName());
			bean.setLevelBegin("" + level.getLevelBegin());
			bean.setLevelEnd("" + level.getLevelEnd());
			bean.setCreateTime(DateUtil.getDate(level.getCreate_date()));
			bean.setCreatePerson(level.getCreatePerson());

			users.add(bean);
		}
		return users;
	}

	public void saveMemberLevel(MemberLevel ml) {
		if (ml != null) {
			String uuid = UUID.randomUUID().toString();
			ml.setLevel_code(uuid);
			ml.setCreate_date(new Date());
			ml.setStatus("1");
			memberLevelManager.saveMemberLevel(ml);
		}

	}

}
