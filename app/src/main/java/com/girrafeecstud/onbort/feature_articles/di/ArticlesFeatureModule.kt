/* Created by Girrafeec */

package com.girrafeecstud.onbort.feature_articles.di

import com.girrafeecstud.onbort.feature_articles.data.datasource.ArticlesDataSource
import com.girrafeecstud.onbort.feature_articles.data.datasource.IArticlesDataSource
import com.girrafeecstud.onbort.feature_articles.data.network.api.ArticlesApi
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticleDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ArticlesListDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.data.network.mapper.ChapterListDtoEntityMapper
import com.girrafeecstud.onbort.feature_articles.domain.ArticlesInteractor
import com.girrafeecstud.onbort.feature_articles.data.repository.ArticlesRepository
import com.girrafeecstud.onbort.feature_articles.domain.IArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [ArticlesFeatureModule.ArticlesFeatureBindModule::class])
@InstallIn(SingletonComponent::class)
class ArticlesFeatureModule {

    @Provides
    fun provideArticlesApi(retrofit: Retrofit): ArticlesApi =
        retrofit.create(ArticlesApi::class.java)

    @Provides
    fun provideChapterListDtoEntityMapper(): ChapterListDtoEntityMapper =
        ChapterListDtoEntityMapper()

    @Provides
    fun provideArticleDtoEntityMapper(
        mapper: ChapterListDtoEntityMapper
    ): ArticleDtoEntityMapper =
        ArticleDtoEntityMapper(chaptersListMapper = mapper)

    @Provides
    fun provideArticlesListDtoEntityMapper(
        mapper: ChapterListDtoEntityMapper
    ): ArticlesListDtoEntityMapper =
        ArticlesListDtoEntityMapper(chaptersListMapper = mapper)

    @Provides
    fun provideArticlesInteractor(repository: IArticlesRepository) =
        ArticlesInteractor(repository = repository)

    @Module
    @InstallIn(SingletonComponent::class)
    interface ArticlesFeatureBindModule {

        @Binds
        fun bindArticlesDataSource(impl: ArticlesDataSource): IArticlesDataSource

        @Binds
        fun bindArticlesRepository(impl: ArticlesRepository): IArticlesRepository

    }

}