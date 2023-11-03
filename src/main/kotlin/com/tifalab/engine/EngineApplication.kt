package com.tifalab.engine


import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EngineApplication: Application() {
	override fun start(stage: Stage) {
		val fxmlLoader = FXMLLoader(EngineApplication::class.java.getResource("hello-view.fxml"))
		val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
		stage.title = "Hello!"
		stage.scene = scene
		stage.show()
	}
	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			Application.launch(EngineApplication::class.java, *args)
		}
	}
}

