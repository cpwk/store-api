package com.maidao.edu.store.common.reposiotry;

import com.maidao.edu.store.common.reposiotry.support.DataQueryObject;
import com.maidao.edu.store.common.reposiotry.support.DataQueryObjectPage;
import com.maidao.edu.store.common.reposiotry.support.DataQueryObjectSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@Transactional(readOnly = true, rollbackFor = Exception.class)
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    List<T> findAll(DataQueryObject query);

    Page<T> findAll(DataQueryObject query, Pageable page);

    Page<T> findAll(DataQueryObjectPage dataQueryObjectpage);

    List<T> findAll(DataQueryObject dataQueryObject, Sort sort);

    List<T> findAll(DataQueryObjectSort dataQueryObjectSort);
}