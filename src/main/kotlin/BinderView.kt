import javafx.scene.control.ScrollPane
import sigmaj.dropbox.SimpleDropboxClientLocal
import sigmaj.notebook.Binder
import tornadofx.*

class BinderView: View() {
    init {
        SimpleDropboxClientLocal.init(System.getProperty("user.home") + "/Dropbox")
    }
    val binder = Binder("/nbktests", SimpleDropboxClientLocal)
    override val root = scrollpane {
        prefHeight = 500.0
        prefWidth = 700.0
        hbarPolicy = ScrollPane.ScrollBarPolicy.NEVER
//        isFitToHeight = true
        isFitToWidth = true
        flowpane {

            for (journal in binder.journals) {
                journalPanel(journal)
            }
        }
    }
}