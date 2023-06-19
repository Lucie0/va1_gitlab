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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class GameScreenVM(
    private val repository: IRacesBetsRepository, private val dsRepository: IDataStoreRepository
) : BaseViewModel() {

    var uiState: MutableState<GameScreenUIState> = mutableStateOf(GameScreenUIState.Loading)
    var dataSavedGame: SavedGame = SavedGame("", 1)
    var dataSavedGameToCard: SavedGameToCard = SavedGameToCard(null, 0, null, 0)

    var actualCardWithDetails: CardWithMoreDetails = CardWithMoreDetails(
        Card("", 0, 0, 0, 0, null), MoreDetails("", 0, 0, 0)
    )
    var actualField: Long = 1L

    var loadGameId: Long? = null
    var playerOnTurn: Long = 1L

    var dataPlayers: ArrayList<Player> = ArrayList(listOf(Player(1), Player(2), Player(3)))
    var playing: Boolean = false

    var boxesArray = ArrayList<MyBox>()
    var diceNumber: Int = 0

    var firstRun: Boolean = false

    fun rollTheDice() {
        diceNumber = (Math.random() * 6).toInt() + 1
//        diceNumber = 1
        actualField += diceNumber
        if (actualField > 40) {
            actualField -= 40
        }
        playing = true

        loadCard()
//        uiState.value = GameScreenUIState.Changed
    }

    fun init() {
        initFirstRun()

        if (loadGameId == null) {
            launch {
                println(":) gameid " + dataSavedGame.id)
                println(":) gameid " + loadGameId)
                println(":) field " + actualField)
                println(":) dataplayers0 " + dataPlayers[0])

//                dataPlayers[0] = repository.getPlayerByIdAndNullGameId(1,)
                println(":) dataplayers0 " + dataPlayers[0])
//                dataPlayers[1] = repository.getPlayerByIdAndNullGameId(2)
//                dataPlayers[2] = repository.getPlayerByIdAndNullGameId(3)

                dataPlayers[0].account = 30000
                dataPlayers[1].account = 30000
                dataPlayers[2].account = 30000

                actualField = dataPlayers[0].field

                actualCardWithDetails.card = repository.getCardById(actualField)
                uiState.value = GameScreenUIState.Initialized
            }
        } else {
            launch {

//                println(":) else gameid " + dataSavedGame.id)
//                println(":) else game id " + loadGameId)
//                println(":) else field " + actualField)
//                println(":) else dataplayers0 " + dataPlayers[0])
                dataPlayers[0] = repository.getPlayerByIdAndGameId(1, loadGameId!!)
//                println(":)" + dataPlayers[0])
                dataPlayers[1] = repository.getPlayerByIdAndGameId(2, loadGameId!!)
//                println(":)" + dataPlayers[1])
                dataPlayers[2] = repository.getPlayerByIdAndGameId(3, loadGameId!!)
//                println(":)" + dataPlayers[2])

                actualField = dataPlayers[0].field

                dataSavedGame = repository.getSavedGameById(loadGameId!!)
                playerOnTurn = dataSavedGame.playerOnTurnId
//                println(":) " + dataPlayers[(playerOnTurn - 1).toInt()].field)
                actualField = dataPlayers[(playerOnTurn - 1).toInt()].field!!
                actualCardWithDetails.card = repository.getCardById(actualField)
                uiState.value = GameScreenUIState.Initialized
            }
        }
    }


    private fun initFirstRun() {
        launch {
            firstRun = dsRepository.getFirstRun()
        }
    }


    fun loadCard() {
        launch {
            actualCardWithDetails.card = repository.getCardById(actualField)
//            println(actualCardWithDetails.card)
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
        dataSavedGame.playerOnTurnId = playerOnTurn

        if (loadGameId == null) {
            launch {
                val idSavedGame = repository.insertSavedGame(dataSavedGame)
                println(":)" + idSavedGame)
                dataSavedGameToCard.savedGameId = idSavedGame
                repository.updateSavedGameToCard(
                    idSavedGame,
//                    dataSavedGameToCard.cardId,
//                    dataSavedGameToCard.playerId!!
                )
//                repository.insertSavedGameToCard(dataSavedGameToCard)
                println(":)" + dataSavedGameToCard)

//                repository.getSavedGameToCardByNullSGId()
//                    .collect { list ->
//                        list?.forEach {
//                            it.savedGameId = idSavedGame
//                            repository.updateSavedGameToCard(idSavedGame, it.cardId, it.playerId!!)
//                        }
//                    }

                dataPlayers[0].gameId = idSavedGame
                dataPlayers[1].gameId = idSavedGame
                dataPlayers[2].gameId = idSavedGame

                repository.insertPlayer(dataPlayers[0])
                repository.insertPlayer(dataPlayers[1])
                repository.insertPlayer(dataPlayers[2])

//                repository.getSavedGameToCardByNullSGId()
//                    .collect { list ->
//                        list?.forEach {
//                            it.savedGameId = idSavedGame
                            repository.updateSavedGameToCard(idSavedGame)//, it.cardId, it.playerId!!)
//                        }
//                    }

                uiState.value = GameScreenUIState.Saved
            }
        } else {
            launch {
                repository.updateSavedGame(dataSavedGame)
                repository.updateSavedGameToCard(
                    loadGameId!!,
//                    dataSavedGameToCard.cardId,
//                    dataSavedGameToCard.playerId!!
                )
                repository.updatePlayer(dataPlayers[0])
                repository.updatePlayer(dataPlayers[1])
                repository.updatePlayer(dataPlayers[2])
                uiState.value = GameScreenUIState.Updated
            }
        }
    }

    fun endMove() {
        playing = false
        diceNumber = 0

//        savePlayer()
        dataPlayers[(playerOnTurn - 1).toInt()].field = actualField
        nextPlayer()
//        initPlayers()
        actualField = dataPlayers[(playerOnTurn - 1).toInt()].field!!
        loadCard()
//        uiState.value = GameScreenUIState.Changed
    }


    private fun nextPlayer() {
        if (playerOnTurn != 3L) {
            playerOnTurn += 1
        } else {
            playerOnTurn = 1
        }
    }

    fun getAccountOfActualPlayer(): Long? {
        return dataPlayers[(playerOnTurn - 1).toInt()].account
    }

    fun buyCard() {
        dataSavedGameToCard.savedGameId = loadGameId
        dataSavedGameToCard.cardId = actualCardWithDetails.card.id!!
        dataSavedGameToCard.playerId = playerOnTurn
        dataSavedGameToCard.moreDetailsId = actualCardWithDetails.card.moreDetailsID!!

        launch {
            val fetched: SavedGameToCard?
            if (loadGameId == null) {
                fetched = repository.getSavedGameToCardByCardIdAndNullSGId(
                    dataSavedGameToCard.cardId
                )
            } else {
                fetched = repository.getSavedGameToCardByCardIdAndSGId(
                    dataSavedGameToCard.cardId,
                    loadGameId ?: 0
                )
            }
            if (fetched == null) {
                repository.insertSavedGameToCard(dataSavedGameToCard)
                uiState.value = GameScreenUIState.CardBought
            } else {
                uiState.value = GameScreenUIState.CardCannotBeBought
            }
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


//    private fun initPlayers() {
//        if (loadGameId == null) {
//            launch {
//                println(":) gameid " + dataSavedGame.id)
//                println(":) gameid " + loadGameId)
//                println(":) field " + actualField)
//                println(":) dataplayers0 " + dataPlayers[0])
//
//                dataPlayers[0] = repository.getPlayerByIdAndNullGameId(1)
//                println(":) dataplayers0 " + dataPlayers[0])
//                dataPlayers[1] = repository.getPlayerByIdAndNullGameId(2)
//                dataPlayers[2] = repository.getPlayerByIdAndNullGameId(3)
//
//                actualField = dataPlayers[0].field!!
//                uiState.value = GameScreenUIState.PlayerInitialized
//            }
//        } else {
//            launch {
//
//                println(":) else gameid " + dataSavedGame.id)
//                println(":) else game id " + loadGameId)
//                println(":) else field " + actualField)
//                println(":) else dataplayers0 " + dataPlayers[0])
//
//                dataPlayers[0] = repository.getPlayerByIdAndGameId(1, loadGameId!!)
//                println(":)" + dataPlayers[0])
//                dataPlayers[1] = repository.getPlayerByIdAndGameId(2, loadGameId!!)
//                println(":)" + dataPlayers[1])
//                dataPlayers[2] = repository.getPlayerByIdAndGameId(3, loadGameId!!)
//                println(":)" + dataPlayers[2])
//
//                actualField = dataPlayers[0].field!!
//                uiState.value = GameScreenUIState.PlayerInitialized
//            }
//        }
//    }

//    fun savePlayer(playerToSave: Player) {
//        launch {
//            repository.updatePlayer(playerToSave)
//            uiState.value = GameScreenUIState.PlayerSaved
//        }
//    }

//    private fun initGame() {
//        if (loadGameId != null) {
//            launch {
//                dataSavedGame = repository.getSavedGameById(loadGameId!!)
//                println(":) " + dataPlayers[(playerOnTurn - 1).toInt()].field)
//                actualField = dataPlayers[(playerOnTurn - 1).toInt()].field!!
//                actualCardWithDetails.card = repository.getCardById(actualField)
//                uiState.value = GameScreenUIState.GameInitialized
//            }
//        } else {
//            launch {
//                actualCardWithDetails.card = repository.getCardById(actualField)
//                uiState.value = GameScreenUIState.GameInitialized
//            }
//        }
//    }