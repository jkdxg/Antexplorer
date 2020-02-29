package com.example.antexplorer.service;

import com.example.antexplorer.pojo.dto.ArticleInfoDTO;

import java.util.List;

/**
 * @author 吴山烤禽
 * @package com.example.antexplorer.service
 * @time 18:08
 * @discribe
 * @since 2020/2/26
 **/
public interface ArticleService {
    ArticleInfoDTO selectByPrimaryKey(int aId);
    List<ArticleInfoDTO>selectByTitle(String title);
    List<ArticleInfoDTO>selectByAuthorId(int Id);
    int insertArtical(ArticleInfoDTO artical, int aId);
    List<String>selectPicContentByArticalId(int articalId);
}
