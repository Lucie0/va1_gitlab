package cz.mendelu.pef.test1.ui.screens.addItem;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcz/mendelu/pef/test1/ui/screens/addItem/AddItemViewModel;", "Lcz/mendelu/pef/test1/architecture/BaseViewModel;", "Lcz/mendelu/pef/test1/ui/screens/addItem/AddItemActions;", "repository", "Lcz/mendelu/pef/test1/database/IWordsRepository;", "(Lcz/mendelu/pef/test1/database/IWordsRepository;)V", "saveWord", "", "cz_word", "", "en_word", "app_debug"})
public final class AddItemViewModel extends cz.mendelu.pef.test1.architecture.BaseViewModel implements cz.mendelu.pef.test1.ui.screens.addItem.AddItemActions {
    private final cz.mendelu.pef.test1.database.IWordsRepository repository = null;
    
    public AddItemViewModel(@org.jetbrains.annotations.NotNull()
    cz.mendelu.pef.test1.database.IWordsRepository repository) {
        super();
    }
    
    @java.lang.Override()
    public void saveWord(@org.jetbrains.annotations.NotNull()
    java.lang.String cz_word, @org.jetbrains.annotations.NotNull()
    java.lang.String en_word) {
    }
}