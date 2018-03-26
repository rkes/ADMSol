package com.chap3;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.chap3.TrieImpl.TrieNodeEntry;

public class TopKFrequentItems {
	private TrieImpl trImpl  ;
	private int size ;
	private final PriorityQueue<TrieNodeEntry> topKItems;
	public TopKFrequentItems(int size){
		this.trImpl = new TrieImpl() ;
		this.size = size;
		topKItems = new PriorityQueue<TrieNodeEntry>(size,(TrieNodeEntry objOne,TrieNodeEntry objTwo)->objOne.frequency-objTwo.frequency);
	}
	public void add(String key){
		trImpl.add(key);
	}
	public List<String> getKMostFreq(){
		for(TrieNodeEntry trNodeEntry : this.trImpl.getAllWords()){
			if(this.topKItems.size()<this.size){
				this.topKItems.add(trNodeEntry);
			}
			else
				if(this.topKItems.peek().frequency<trNodeEntry.frequency){
					this.topKItems.remove();
					this.topKItems.add(trNodeEntry);
				}
		}
		return this.topKItems.stream().map(entry->entry.key).collect(Collectors.toList());
	}
	public static void main(String []args){
		TopKFrequentItems topKFrequentItems = new TopKFrequentItems(1);
		topKFrequentItems.add("Hi");topKFrequentItems.add("Hi");topKFrequentItems.add("Hello");topKFrequentItems.add("TShirt");
		topKFrequentItems.add("TShirt");topKFrequentItems.add("TShirt");topKFrequentItems.add("TShirt");topKFrequentItems.add("TShirt");
		System.out.println(topKFrequentItems.getKMostFreq());
	}
}
