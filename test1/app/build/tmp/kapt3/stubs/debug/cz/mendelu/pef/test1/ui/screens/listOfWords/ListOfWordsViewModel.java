package cz.mendelu.pef.test1.ui.screens.listOfWords;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsViewModel;", "Lcz/mendelu/pef/test1/architecture/BaseViewModel;", "repository", "Lcz/mendelu/pef/test1/database/IWordsRepository;", "(Lcz/mendelu/pef/test1/database/IWordsRepository;)V", "wordListUIState", "Landroidx/compose/runtime/MutableState;", "Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState;", "getWordListUIState", "()Landroidx/compose/runtime/MutableState;", "loadWords", "", "app_debug"})
public final class ListOfWordsViewModel extends cz.mendelu.pef.test1.architecture.BaseViewModel {
    private final cz.mendelu.pef.test1.database.IWordsRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsUIState> wordListUIState = null;
    
    public ListOfWordsViewModel(@org.jetbrains.annotations.NotNull()
    cz.mendelu.pef.test1.database.IWordsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsUIState> getWordListUIState() {
        return null;
    }
    
    public final void loadWords() {
    }
}