package com.yinghua.jilijili.pagding.moviepagding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.yinghua.jilijili.bean.Movie;

public class MovieViewMode extends ViewModel {
    public LiveData<PagedList<Movie>> moviePageList;

    public MovieViewMode() {
        PagedList.Config config= (new PagedList.Config.Builder())
                .setEnablePlaceholders(false) //设置控件占位，是否预留已知数据的位置
                .setPageSize(MovieDataSource.PGE)//设置每一页的大小，通常与DataSource中的请求参数保持一致
                .setPrefetchDistance(3)//设置距离底部还有多少距离开始加载下一页的数据
                .setInitialLoadSizeHint(MovieDataSource.PGE*10)//设置首次加载的数据的数量，默认是 PageSiez的3倍
                .setMaxSize(6400 * MovieDataSource.PGE)//设置PagList所能承受的最大数量，一般来说是PageSiez的许多倍。超过会报出异常
                .build();
        moviePageList = new LivePagedListBuilder<>(new MovieDataSourceFactory(), config).build();
    }
}
