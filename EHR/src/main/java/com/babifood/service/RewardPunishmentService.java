package com.babifood.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.babifood.entity.RewardPunishmentEntity;


@Service
public interface RewardPunishmentService {
	
	//奖惩项目
	public List<Map<String,Object>> loadRAPItemAll(String category_id,String item_name);
		
	public Integer saveRAPItem(String item_id,String item_name,String category_id);
		
	public Integer eidtRAPItem(String item_id,String item_name,String category_id);
		
	public Integer removeRAPItem(String item_id);
	
	//奖惩记录
	public List<Map<String,Object>> loadComboboxRAPItemData();
		
	public List<Map<String,Object>> loadRewardPunishment(String rap_category, String rap_item);
		
	public int[] saveRewardPunishment(RewardPunishmentEntity rewardpunishmentEntity);
		
	public Integer editRewardPunishment(RewardPunishmentEntity rewardpunishmentEntity);
	
	public Integer removeRewardPunishment(String rap_id);
	
	
}
