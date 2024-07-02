package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
	// 管理者用の民宿一覧ページ
	// 民宿名で検索
	public Page<House> findByNameLike(String keyword, Pageable pageable);

	// 民宿一覧ページ
	// 民宿名または目的地で検索する（新着順）
	public Page<House> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword, Pageable pageable);
	
	// 民宿名または目的地で検索する（宿泊料金が安い順）
	public Page<House> findByNameLikeOrAddressLikeOrderByPriceAsc(String nameKeyword, String addressKeyword, Pageable pageable);
	
	// エリアで検索する（新着順）
	public Page<House> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);
	
	// エリアで検索する（宿泊料金が安い順）
	public Page<House> findByAddressLikeOrderByPriceAsc(String area, Pageable pageable);
	
	// 1泊あたりの予算で検索する（新着順）
	public Page<House> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);
	
	// 1泊あたりの予算で検索する（宿泊料金が安い順）
	public Page<House> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable);
	
	// すべてのデータを取得する（新着順）
	public Page<House> findAllByOrderByCreatedAtDesc(Pageable pageable);
	
	// すべてのデータを取得する（宿泊料金が安い順）
	public Page<House> findAllByOrderByPriceAsc(Pageable pageable);
	
	
	// トップページ
	// 10件取得
	public List<House> findTop10ByOrderByCreatedAtDesc();
}
