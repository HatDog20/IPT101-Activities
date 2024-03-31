import mu.KotlinLogging


/*class Logger {



}*/
private val logger = KotlinLogging.logger {}
open class MediaItem(val title: String, val artist: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MediaItem) return false
        return title == other.title && artist == other.artist
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + artist.hashCode()
        return result
    }
}

class Song(title: String, artist: String) : MediaItem(title, artist)

class Playlist {

    val mediaItems: MutableList<MediaItem> = mutableListOf()

    fun addMediaItem(item: MediaItem) {
        val trimmedTitle = item.title
        val trimmedArtist = item.artist
        val newItem = MediaItem(trimmedTitle, trimmedArtist)
        if (!mediaItems.contains(newItem)) {
            mediaItems.add(newItem)
            logger.info { "Saving songs...Please wait...." }
            println("\n$trimmedTitle by $trimmedArtist is added to the playlist.")
        } else {
            println("$trimmedTitle is already added to the playlist.")
        }
    }

    fun getMediaItemAt(index: Int): MediaItem? {
        return if (index in mediaItems.indices) {
            mediaItems[index]
        } else {
            null
        }
    }

    fun changeMediaItem(oldItem: MediaItem, newItem: MediaItem) {
        val index = mediaItems.indexOf(oldItem)
        if (index != -1) {
            mediaItems[index] = newItem
        }
    }

    fun changeMediaItemByArtist(playlist: Playlist) {
        print("\nPlease select number you want to change: ")
        val songIndex = readLine()?.toIntOrNull() ?: -1
        if (songIndex in 1..playlist.totalNumberOfSongs()) {
            val selectedSong = playlist.getMediaItemAt(songIndex - 1)
            println("Selected Song: ${selectedSong!!.title} by ${selectedSong.artist}")
            println()
            print("Enter new song name: ")
            val newTitle = readLine() ?: ""
            print("Enter new artist name: ")
            val newArtist = readLine() ?: ""
            val newMediaItem = MediaItem(newTitle, newArtist)
            print("Are you sure you want to change ${selectedSong.title} by ${selectedSong.artist}? (y/n): ")
            val confirmation = readLine()?.toLowerCase() ?: ""
            if (confirmation == "y" || confirmation == "yes") {
                if (selectedSong != newMediaItem) {
                    playlist.changeMediaItem(selectedSong, newMediaItem)
                    logger.info { "Please wait to change...." }
                    println("\n${selectedSong.title} by ${selectedSong.artist} is changed to $newTitle by $newArtist.")
                } else {
                    println("$newTitle by $newArtist is already in the playlist.")
                }
            } else {
                logger.info("No changes made.")
            }
        } else {
            logger.warn("Invalid number not in the choice")
        }
    }

    fun removeMediaItem(item: MediaItem) {
        val trimmedTitle = item.title.trim().replace("\\s+".toRegex(), "")
        val trimmedArtist = item.artist.trim().replace("\\s+".toRegex(), "")
        val foundItem = mediaItems.find {
            it.title.replace(
                "\\s+".toRegex(),
                ""
            ) == trimmedTitle && it.artist.replace("\\s+".toRegex(), "") == trimmedArtist
        }
        if (foundItem != null) {
            mediaItems.remove(foundItem)
            logger.info { "Please wait removing your song...." }
            logger.info("${foundItem.title} by ${foundItem.artist} is removed from the playlist.")
        }
    }

    fun searchSong(song: String) {
        val trimmedSong = song.trim().replace("\\s+".toRegex(), "")
        val item = mediaItems.find { it.title.replace("\\s+".toRegex(), "") == trimmedSong }
        if (item != null) {
            println("$song is found in the playlist.")
        } else {
            logger.info("$song is not found in the playlist.")
        }
    }

    fun searchByArtist(artist: String) {
        val trimmedArtist = artist.trim().replace("\\s+".toRegex(), "")
        val count = mediaItems.count { it.artist.replace("\\s+".toRegex(), "") == trimmedArtist }
        if(count>0){
            println("$artist is found in the playlist with $count songs.")
        }else{
            logger.info("$artist is not found in the playlist.")
        }


    }

    fun clearPlaylist() {
        print("Are you sure you want to clear playlist? (y/n): ")
        val confirmation = readLine()?.toLowerCase() ?: ""
        if (confirmation == "y" || confirmation == "yes") {
            mediaItems.clear()
            logger.info("Playlist is cleared.")
        } else {
            logger.info("Playlist is not cleared..")
        }


    }

    fun displayAllMediaItems() {
        if (mediaItems.isNotEmpty()) {
            println("\n****** VENTURES PLAYLIST******")
            mediaItems.forEachIndexed { index, mediaItem ->
                println("${index + 1}. ${mediaItem.title} by ${mediaItem.artist}")
            }
        } else {
            logger.info("The playlist is empty.")

        }
    }

    fun display() {
        if (mediaItems.isNotEmpty()) {
            mediaItems.forEachIndexed { index, mediaItem ->
                println("${index + 1}. ${mediaItem.title} by ${mediaItem.artist}")
            }
        } else {
            logger.info("The playlist is empty.")

        }
    }

    fun displaySongsByArtist(selectedArtist: String) {
        val songsByArtist = mediaItems.filter { it.artist == selectedArtist }
        if (songsByArtist.isNotEmpty()) {
            println("Songs by $selectedArtist in the playlist:")
            songsByArtist.forEachIndexed { index, mediaItem ->
                println("${index + 1}. ${mediaItem.title}")
            }
        } else {
            println("No songs by $selectedArtist found in the playlist.")
        }
    }

    fun totalNumberOfSongs(): Int {
        return mediaItems.size
    }

    fun displayAllArtists() {
        if (mediaItems.isEmpty()) {
            logger.info("Playlist is empty.")
        } else {
            val uniqueArtists = mediaItems.map { it.artist }.distinct()
            println("\nAll artist names in the playlist:")
            uniqueArtists.forEachIndexed { index, artist ->
                println("${index + 1}. $artist")
            }
        }
    }
}
fun main() {
//Albit, Anfred
//Amora, Cris Aljon
//Caupit, Ken
//Ventures, Joseph

    val playlist = Playlist()
    do {
        println()
        println("\n****** VENTURES PLAYLIST*****")
        println("1. Add new song")
        println("2. Change song")
        println("3. Remove a song")
        println("4. Search song")
        println("5. Search artist")
        println("6. Display all song name")
        println("7. Display all artist name")
        println("8. Display songs by artist")
        println("9. Display Playlist")
        println("10. Empty playlist")
        println("11. Exit")

        print("\nEnter your choice: ")
        val choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> {
                print("\nEnter song name: ")
                val songTitle = readLine() ?: ""
                print("Enter artist name: ")
                val artistName = readLine() ?: ""

                if (songTitle == "" || artistName == "") {
                    logger.warn("Please enter song name or artist name!")
                } else {
                    val song = Song(songTitle, artistName)
                    playlist.addMediaItem(song)
                }
            }

            2 -> {
                playlist.display()
                if (playlist.totalNumberOfSongs() > 0) {
                    playlist.changeMediaItemByArtist(playlist)
                } else {
                }

            }

            3 -> {
                playlist.display()
                if (playlist.totalNumberOfSongs() > 0) {
                    print("\nPlease select a number you want to remove: ")
                    val songIndex = readLine()?.toIntOrNull() ?: -1
                    if (songIndex in 1..playlist.totalNumberOfSongs()) {
                        val songToRemove = playlist.getMediaItemAt(songIndex - 1)
                        print("Are you sure you want to remove ${songToRemove!!.title} by ${songToRemove!!.artist}? (y/n): ")
                        val confirmation = readLine()?.toLowerCase() ?: ""
                        if (confirmation == "y" || confirmation == "yes") {
                            playlist.removeMediaItem(songToRemove!!)
                        } else {
                            logger.info("${songToRemove.title} by ${songToRemove.artist} not remove.")
                        }
                    } else {
                        logger.warn("Invalid song number. No changes made.")
                    }
                } else {
                }
            }

            4 -> {
                if (playlist.mediaItems.isEmpty()) {
                    logger.info("Playlist is empty!")
                } else {
                    print("\nEnter song name to search: ")
                    val songTitle = readLine() ?: ""
                    if (songTitle == "") {
                        logger.info("Please enter a song name to search!")
                    } else {
                        playlist.searchSong(songTitle)
                    }
                }
            }

            5 -> {
                if (playlist.mediaItems.isEmpty()) {
                    logger.info("Playlist is empty!")
                } else {
                    print("\nEnter artist name to search: ")
                    val artistName = readLine() ?: ""
                    if (artistName == "") {
                        logger.info("Please enter artist name to search!")
                    } else {
                        playlist.searchByArtist(artistName)
                    }
                }
            }

            6 -> {
                if (playlist.totalNumberOfSongs() > 0) {
                    println("\nAll song name in the playlist:")
                    playlist.mediaItems.forEachIndexed { index, song ->
                        println("${index + 1}. ${song.title}")
                    }
                } else {
                    logger.info("No songs in the playlist.")
                    println()
                }
            }

            7 -> {
                playlist.displayAllArtists()
            }

            9 -> playlist.displayAllMediaItems()
            8 -> {
                if (playlist.mediaItems.isEmpty()) {
                    logger.info("Playlist is Empty!")
                } else {
                    val uniqueArtists = playlist.mediaItems.map { it.artist }.distinct()
                    println("\nAll artist name in the playlist.")
                    uniqueArtists.forEachIndexed { index, artist ->
                        println("${index + 1}. $artist")
                    }
                    print("\nEnter the number of the artist to display his/her songs: ")
                    val artistIndex = readLine()?.toIntOrNull() ?: -1
                    if (artistIndex in 1..uniqueArtists.size) {
                        val selectedArtist = uniqueArtists[artistIndex - 1]
                        playlist.displaySongsByArtist(selectedArtist)
                    } else {
                        logger.info("Invalid artist number.")
                    }
                }
            }

            10 ->
                if (playlist.mediaItems.isEmpty()) {
                    logger.info("Playlist Empty!")
                } else {
                    playlist.clearPlaylist()
                }

            11 -> return
            else -> {
                logger.warn("Invalid choice.")
                logger.warn { "Please select between 1 to 11...." }
            }
        }
    } while (true)
}
