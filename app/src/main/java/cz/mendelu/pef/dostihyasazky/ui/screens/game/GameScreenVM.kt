package cz.mendelu.pef.dostihyasazky.ui.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import cz.mendelu.pef.dostihyasazky.datastore.DataStoreConstants
import cz.mendelu.pef.dostihyasazky.datastore.IDataStoreRepository
import cz.mendelu.pef.dostihyasazky.di.repositoryModule
import cz.mendelu.pef.dostihyasazky.model.*
import cz.mendelu.pef.dostihyasazky.ui.elements.MyBox
import cz.mendelu.pef.dostihyasazky.ui.screens.saved_game_detail.SavedGameDetailUIState
import cz.mendelu.pef.dostihyasazky.ui.utils.DateUtils
import kotlinx.coroutines.launch

class GameScreenVM(
    private val repository: IRacesBetsRepository,
    private val dsRepository: IDataStoreRepository
) : BaseViewModel() {

    var uiState: MutableState<GameScreenUIState> = mutableStateOf(GameScreenUIState.Loading)
    var dataSavedGame: SavedGame = SavedGame("", 1)
    var dataSavedGameToCard: SavedGameToCard = SavedGameToCard(null, 0, null, 0)

    var actualField: Long = 1L
    var actualCardWithDetails: CardWithMoreDetails = CardWithMoreDetails(
        Card("", 0, 0, 0, 0, null),
        MoreDetails("", 0, 0, 0)
    )

    var dataPlayer: Player = Player(dataSavedGame.playerOnTurnId)

    var playing: Boolean = false

    var loadGameId: Long? = -1L

    var boxesArray = ArrayList<MyBox>()
    var diceNumber: Int = 0

    var firstRun: Boolean = false

    fun rollTheDice() {
//        diceNumber = (Math.random() * 6).toInt() + 1
        diceNumber = 1

//        println(":) " +actualField + " "+ diceNumber)
        actualField += diceNumber
        if (actualField > 40) {
            actualField -= 40
        }
        playing = true

        loadCard()
//        uiState.value = GameScreenUIState.Changed
//        println(diceNumber)
    }

    fun init() {
        initFirstRun()
        initPlayer()
        initGame()
    }

    private fun initGame() {
        if (loadGameId != -1L) {
            launch {
                dataSavedGame = repository.getSavedGameById(loadGameId!!)
                actualCardWithDetails.card = repository.getCardById(actualField)
                uiState.value = GameScreenUIState.Changed
            }
        } else {
            launch {
                actualCardWithDetails.card = repository.getCardById(actualField)
                uiState.value = GameScreenUIState.Changed
            }
        }
    }

    private fun initFirstRun() {
        launch {
            firstRun = dsRepository.getFirstRun()
        }
    }

    fun savePlayer() {
        dataPlayer.playerId = dataSavedGame.playerOnTurnId
        dataPlayer.field = actualField

        launch {
            repository.updatePlayer(dataPlayer)
            uiState.value = GameScreenUIState.PlayerSaved
        }
    }

    fun initPlayer() {
        if (dataSavedGame.id != null) {
            launch {
                dataPlayer = repository.getPlayerByIdAndGameId(
                    dataSavedGame.playerOnTurnId,
                    dataSavedGame.id!!
                )
                actualField = dataPlayer.field!!
                uiState.value = GameScreenUIState.PlayerInitialized
            }
        } else {
            launch {
                dataPlayer = repository.getPlayerByIdAndNullGameId(dataSavedGame.playerOnTurnId)
                actualField = dataPlayer.field!!
                uiState.value = GameScreenUIState.PlayerInitialized
            }
        }
    }

    fun loadCard() {
        launch {
            actualCardWithDetails.card = repository.getCardById(actualField)
            println(actualCardWithDetails.card)
            uiState.value = GameScreenUIState.CardLoaded
        }
    }

    fun alreadyFirstRun() {
        launch {
            dsRepository.setFirstRun()
            firstRun = dsRepository.getFirstRun()
            uiState.value = GameScreenUIState.Changed
        }
    }

    fun saveGame() {
        dataSavedGame.date = DateUtils.getToday(true)
//        println(":)" + data.date)


        if (loadGameId == -1L) {
            launch {
                val idSavedGame = repository.insertSavedGame(dataSavedGame)
                dataSavedGameToCard.savedGameId = idSavedGame

                repository.updateSavedGameToCard(dataSavedGameToCard)
                uiState.value = GameScreenUIState.Saved
            }
        } else {
            launch {
                repository.updateSavedGame(dataSavedGame)
                uiState.value = GameScreenUIState.Updated
            }
        }
    }

    fun endMove() {
        playing = false
        diceNumber = 0

        savePlayer()
        nextPlayer()

        initPlayer()

        //
        actualField = dataPlayer.field!!
        loadCard()

        //
//        uiState.value = GameScreenUIState.Changed
    }



    private fun nextPlayer() {
        if (dataSavedGame.playerOnTurnId != 3L) {
            dataSavedGame.playerOnTurnId += 1
        } else {
            dataSavedGame.playerOnTurnId = 1
        }
    }

}


//    fun initBoxesArray() {
//        boxesArray.add(MyBox(1, 10, 10, "Start"))
//        boxesArray.add(MyBox(2, 10, 10, "Fantome"))
//        boxesArray.add(MyBox(3, 10, 10, "Finance"))
//        boxesArray.add(MyBox(4, 10, 10, "Gavora"))
//        boxesArray.add(MyBox(5, 10, 10, "Klinika 1"))
//        boxesArray.add(MyBox(6, 10, 10, "Trenér 1"))
//        boxesArray.add(MyBox(7, 10, 10, "Lady Anne"))
//        boxesArray.add(MyBox(8, 10, 10, "Náhoda"))
//        boxesArray.add(MyBox(9, 10, 10, "Pasek"))
//        boxesArray.add(MyBox(10, 10, 10, "Koran"))
//        boxesArray.add(MyBox(11, 10, 10, "Distance"))
//        boxesArray.add(MyBox(12, 10, 10, "Neklan"))
//        boxesArray.add(MyBox(13, 10, 10, "Přeprava"))
//        boxesArray.add(MyBox(14, 10, 10, "Portlanc"))
//        boxesArray.add(MyBox(15, 10, 10, "Japan"))
//        boxesArray.add(MyBox(16, 10, 10, "Trenér 2"))
//        boxesArray.add(MyBox(17, 10, 10, "Kostrava"))
////        tady finance, uz zapsany
//        boxesArray.add(MyBox(18, 10, 10, "Lukava"))
//        boxesArray.add(MyBox(19, 10, 10, "Melák"))
//        boxesArray.add(MyBox(20, 10, 10, "Parkoviště"))
//        boxesArray.add(MyBox(21, 10, 10, "Grifel"))
////        nahoda
//        boxesArray.add(MyBox(23, 10, 10, "Mohyla"))
//        boxesArray.add(MyBox(24, 10, 10, "Metál"))
//        boxesArray.add(MyBox(25, 10, 10, "Trenér 3"))
//        boxesArray.add(MyBox(26, 10, 10, "Tara"))
//        boxesArray.add(MyBox(27, 10, 10, "Furioso"))
//        boxesArray.add(MyBox(28, 10, 10, "Stáje"))
//        boxesArray.add(MyBox(29, 10, 10, "Génius"))
//        boxesArray.add(MyBox(30, 10, 10, "Podezření z dopingu"))
//        boxesArray.add(MyBox(31, 10, 10, "Shagga"))
//        boxesArray.add(MyBox(32, 10, 10, "Dahoman"))
////        finance
//        boxesArray.add(MyBox(33, 10, 10, "Gira"))
//        boxesArray.add(MyBox(34, 10, 10, "Trenér 4"))
////        nahoda
//        boxesArray.add(MyBox(35, 10, 10, "Narcius"))
//        boxesArray.add(MyBox(36, 10, 10, "Klinika 2"))
//        boxesArray.add(MyBox(37, 10, 10, "Napoli"))
//    }