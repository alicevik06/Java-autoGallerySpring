package com.example.autogalleryspring.repo.base;

import com.example.autogalleryspring.entity.Abstract.Kisi;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@NoRepositoryBean
@RepositoryRestResource(exported = false)
public interface IKisiEntityRepo<T extends Kisi,ID extends Long> extends IBaseEntityRepo<T,ID> {
    List<T> findAllByTcKimlikNo(String tc);
}
