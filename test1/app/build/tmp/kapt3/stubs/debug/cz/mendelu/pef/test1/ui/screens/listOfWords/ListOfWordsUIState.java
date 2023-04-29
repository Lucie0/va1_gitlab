package cz.mendelu.pef.test1.ui.screens.listOfWords;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState;", "", "()V", "Default", "Success", "Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState$Default;", "Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState$Success;", "app_debug"})
public abstract class ListOfWordsUIState {
    
    private ListOfWordsUIState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState$Default;", "Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState;", "()V", "app_debug"})
    public static final class Default extends cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsUIState {
        @org.jetbrains.annotations.NotNull()
        public static final cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsUIState.Default INSTANCE = null;
        
        private Default() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState$Success;", "Lcz/mendelu/pef/test1/ui/screens/listOfWords/ListOfWordsUIState;", "words", "", "Lcz/mendelu/pef/test1/model/Word;", "(Ljava/util/List;)V", "getWords", "()Ljava/util/List;", "app_debug"})
    public static final class Success extends cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsUIState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<cz.mendelu.pef.test1.model.Word> words = null;
        
        public Success(@org.jetbrains.annotations.NotNull()
        java.util.List<cz.mendelu.pef.test1.model.Word> words) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<cz.mendelu.pef.test1.model.Word> getWords() {
            return null;
        }
    }
}