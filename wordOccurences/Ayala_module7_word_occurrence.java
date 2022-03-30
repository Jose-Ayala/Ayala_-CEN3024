/*
 * Author Name: Jose Ayala
 * Date: 3/16/2022
 * Program Name: Ayala_module7_word_occurrence
 * Purpose: A text analyzer that reads a file and outputs statistics about that file.
*/

package wordOccurences;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * <h1>Ayala_module7_word_occurrence</h1> A text analyzer that reads a file and
 * outputs statistics about that file.
 *
 * @author Jose Ayala
 * @version 1.0
 * @since 2022-03-30
 */
public class Ayala_module7_word_occurrence extends Application {

	/**
	 * This is the start method which shows the JavaFX stage.
	 * 
	 * @param stage A stage (window) contains all the objects of a JavaFX application..
	 * @return Nothing
	 * @exception IOException - Input error.
	 * @see IOException
	 * @exception MalformedURLException - Input error.
	 * @see MalformedURLException
	 */
	public void start(Stage stage) {

		try {

			// Set title
			stage.setTitle("Word Occurrence Application");

			// Create the URL text field
			final TextField url = new TextField();
			url.setPromptText("Please enter a  URL and click OK.");
			url.setFocusTraversable(false);
			url.setPrefColumnCount(30);
			url.getText();

			// Create HBox pane for buttons
			HBox buttons = new HBox(8);
			buttons.setAlignment(Pos.TOP_LEFT);
			Button okButton = new Button("OK");
			Button exitButton = new Button("Exit");
			buttons.getChildren().addAll(okButton, exitButton);

			// Create a main flow pane
			FlowPane main = new FlowPane();
			main.setOrientation(Orientation.HORIZONTAL);
			main.setPadding(new Insets(10));
			main.setHgap(10);
			main.setVgap(5);
			main.getChildren().addAll(url, buttons);

			// Create a VBox to display the words and their count
			VBox wordCounts = new VBox();

			// Create a ScrollPane
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setFitToWidth(false);
			scrollPane.fitToHeightProperty().set(true);
			scrollPane.setPadding(new Insets(0, 0, 5, 20));
			scrollPane.setStyle("-fx-background-color:transparent;");

			// Create a VBox
			VBox vbox = new VBox(30, main);
			vbox.setAlignment(Pos.TOP_LEFT);

			// Create a scene
			Scene scene = new Scene(vbox, 700, 500);

			// Set the scene
			stage.setScene(scene);

			/////////////////////////////////////
			// Event handlers for buttons
			/////////////////////////////////////

			// Exit button event handler
			exitButton.setOnAction(e -> System.exit(0));

			// OK button event handler
			okButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					// Clear any previous labels added to wordCounts
					wordCounts.getChildren().clear();

					if ((url.getText() != null && !url.getText().isEmpty())) {

						String urlText = "";
						try {

							// Get the URL entered and open a stream
							URL urlEntered = new URL(url.getText());
							Scanner scanner = new Scanner(urlEntered.openStream());

							while (scanner.hasNext()) {
								urlText = urlText.toUpperCase() + " " + scanner.nextLine();
							}
							
							// Call the createWordsArray method to put all words from the text in an array
							String[] wordsArray = createWordsArray(urlText);
							
							// Call the createSortedFreqmap to count the occurrence of each word and sort
							// the words by number of occurrences in descending order.
							LinkedHashMap<String, Integer> sortedMap = createSortedFreqMap(wordsArray);

							// Add a heading
							String heading = "Below are the top 20 words found in the text and their number of occurences:";
							Label lblHeading = new Label(heading);
							lblHeading.setPadding(new Insets(15, 0, 10, 0));
							wordCounts.getChildren().add(lblHeading);

							// Create a label for each of the top 20 words and their count and add to
							// wordCounts vbox
							
							int topTwenty = 20;
							for (Entry<String, Integer> result : sortedMap.entrySet()) {
								
								if (topTwenty <= 0)
								{
									break;
								}

								String labelText = result.getKey() + " = " + result.getValue();
								Label word = new Label(labelText);
								word.setAlignment(Pos.TOP_RIGHT);
								wordCounts.getChildren().add(word);
								topTwenty--;
							}

						} catch (MalformedURLException exception) {

							String errorText = "ERROR - You entered an invalid URL, please try again.";
							Label error = new Label(errorText);
							wordCounts.getChildren().add(error);

						} catch (IOException exception) {

							String errorText = "ERROR - An error has occured, please try again.";
							Label error = new Label(errorText);
							wordCounts.getChildren().add(error);

						}

						scrollPane.setContent(wordCounts);
						vbox.getChildren().add(scrollPane);
					} else {
						// Display an error if no URL is entered.
						String errorText = "ERROR - Please enter a valid URL and try again.";
						Label error = new Label(errorText);
						wordCounts.getChildren().add(error);
						scrollPane.setContent(wordCounts);
						vbox.getChildren().add(scrollPane);
					}
				}

			});

			stage.show();
		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Put all words from the text in an array.
	 * 
	 * @param urlText The text obtained from the provided url.
	 */
	public String[] createWordsArray(String urlText) {
		// Remove all HTML
		urlText = urlText.replaceAll("\\<[^>]*>", "");

		// Remove all excess whitespace
		urlText = urlText.trim().replaceAll(" +", " ");

		// Store urlText in array and split
		String[] wordsArray = urlText.split(" ");
		
		return wordsArray;
	}
	
	
	/**
	 * Count the occurrence of each word and sort the words by number of occurrences in descending order.
	 * 
	 * @param wordsArray An array of words to be sorted.
	 */
	public LinkedHashMap<String, Integer> createSortedFreqMap(String[] wordsArray) {
		
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();

		for (int i = 0; i < wordsArray.length; i++) {
			String key = wordsArray[i];
			int freq = freqMap.getOrDefault(key, 0);
			freqMap.put(key, ++freq);
		}

		// Sort the freqMap by value in descending order
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		return sortedMap;
	}

	/**
	 * Main method which launches the application.
	 * @param args The command line arguments.
	 **/
	public static void main(String[] args) {
		launch(args);
	}

}
