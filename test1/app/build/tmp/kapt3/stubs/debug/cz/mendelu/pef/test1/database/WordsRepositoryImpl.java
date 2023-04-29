package cz.mendelu.pef.test1.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcz/mendelu/pef/test1/database/WordsRepositoryImpl;", "Lcz/mendelu/pef/test1/database/IWordsRepository;", "dao", "Lcz/mendelu/pef/test1/database/WordsDao;", "(Lcz/mendelu/pef/test1/database/WordsDao;)V", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcz/mendelu/pef/test1/model/Word;", "insert", "", "word", "(Lcz/mendelu/pef/test1/model/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WordsRepositoryImpl implements cz.mendelu.pef.test1.database.IWordsRepository {
    private final cz.mendelu.pef.test1.database.WordsDao dao = null;
    
    public WordsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    cz.mendelu.pef.test1.database.WordsDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<cz.mendelu.pef.test1.model.Word>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    cz.mendelu.pef.test1.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
}