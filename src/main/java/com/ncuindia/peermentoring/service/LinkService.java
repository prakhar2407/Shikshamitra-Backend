package com.ncuindia.peermentoring.service;

import java.util.List;

import com.ncuindia.peermentoring.model.Link;

public interface LinkService {
	public Link saveLink(Link link);
	public List<Link> getAllLinks();
}
