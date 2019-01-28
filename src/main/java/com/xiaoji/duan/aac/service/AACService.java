package com.xiaoji.duan.aac.service;

import org.springframework.stereotype.Service;

import com.xiaoji.duan.aac.entity.AAC_Homepage;
import com.xiaoji.duan.aac.mapper.AAC_HomepageMapper;

@Service
public class AACService {

	private final AAC_HomepageMapper homepageMapper;
	
	public AACService(AAC_HomepageMapper homepageMapper) {
		this.homepageMapper = homepageMapper;
	}
	
	public AAC_Homepage getSubdomainHomepage(String subdomain) {
		return this.homepageMapper.findByPK("", subdomain);
	}
}
