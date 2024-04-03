package com.example.newsapp.presentaion.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.domain.NewsItem
import com.example.newsapp.presentaion.ui.components.NewsCard
import com.example.newsapp.utlis.NavActions
import com.example.newsapp.utlis.NavRoutes
import com.example.newsapp.viewmodels.mainViewmodel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import java.time.Instant
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navActions: NavActions) {
    val viewmodel: mainViewmodel = viewModel()

    val selectedItem = viewmodel.selectedTab
    navActions.navigateToHome

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedItem == TabItem.SearchTap,
                    onClick = {
                        viewmodel.updateSelectedTab(TabItem.SearchTap)
                        navActions.navigateToSearch.invoke()

                    },
                    icon = {
                        Icon(
                            Icons.Outlined.Search,
                            contentDescription = "search news tap"
                        )
                    },
                    label = {
                        Text(text = "search")
                    },
                    alwaysShowLabel = false

                )
                NavigationBarItem(
                    selected = selectedItem == TabItem.FavoriteTap,
                    onClick = {
                        viewmodel.updateSelectedTab(TabItem.FavoriteTap)
                        navActions.navigateToFavorites.invoke()
                    },

                    icon = {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "favorite news tap"
                        )
                    },
                    label = {
                        Text(text = "favorites")
                    },
                    alwaysShowLabel = false
                )
            }
        }


    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            border = BorderStroke(2.dp, Color.Cyan),

            )
        {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                NavHost(
                    navController = navActions.navController,
                    startDestination = NavRoutes.HOME
                ) {
                    println(navActions.navController.toString())
                    composable(NavRoutes.HOME) {
                        Mainscreen()
                    }
                    composable(NavRoutes.SEARCH) {
                        SearchScreen()
                    }

                    composable(NavRoutes.FAVORITES) {
                        FavoriteScreen()
                    }

                }

            }

        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Mainscreen() {
    /* experimental  */
    val news = listOf(
        NewsItem(
            author = null,
            title = "The Greatest App of All Time Final Round: Google Maps vs. Flashlight",
            description = "Welcome to the final round of Gizmodo’s March Madness bracket challenge to name the greatest app of all time! After outliving billion-dollar apps with billions of users all month long, Calculator was finally eliminated by Flashlight in yesterday’s tournament.…",
            url = "https://gizmodo.com/the-greatest-app-of-all-time-final-round-google-maps-v-1851377500",
            imageUrl = "https://i.kinja-img.com/image/upload/c_fill,h_675,pg_1,q_80,w_1200/10ac28431295bca771cfa352c74c4fd5.jpg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        ),
        NewsItem(
            author = "Aaron Mok",
            title = "9 AI hacks that Mark Zuckerberg, Sundar Pichai, Jensen Huang, and other business leaders use",
            description = "Some of the world's most influential business leaders have been incorporating AI into their lives. Here's how CEOs from Meta and Google use the tech",
            url = "https://www.businessinsider.com/ai-hacks-of-execs-including-meta-google-and-microsofts-ceo-2024-3",
            imageUrl = "https://i.insider.com/6605c61e3f923f7dab025875?width=1200&format=jpeg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        ),
        NewsItem(
            author = "Javier Lacort",
            title = "Opera lleva 30 años plantando cara a gigantes como Microsoft, Google y Apple. Así planea seguir haciéndolo otros 30 años",
            description = "Hablar de navegadores en la era de TikTok, Instagram, ChatGPT y Netflix quizás suene casi anacrónico, como si se hubiesen convertido en una commodity y lo importante fuese lo que ocurre dentro de su ventana, no en los bordes. Como si se tratase de una guerra …",
            url = "https://www.xataka.com/aplicaciones/opera-lleva-30-anos-plantando-cara-a-gigantes-como-microsoft-google-apple-asi-planea-seguir-haciendolo-otros-30-anos",
            imageUrl = "https://i.blogs.es/021f43/operadest1/840_560.jpeg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        )
        ,
        NewsItem(
            author = "Javier Lacort",
            title = "Opera lleva 30 años plantando cara a gigantes como Microsoft, Google y Apple. Así planea seguir haciéndolo otros 30 años",
            description = "Hablar de navegadores en la era de TikTok, Instagram, ChatGPT y Netflix quizás suene casi anacrónico, como si se hubiesen convertido en una commodity y lo importante fuese lo que ocurre dentro de su ventana, no en los bordes. Como si se tratase de una guerra …",
            url = "https://www.xataka.com/aplicaciones/opera-lleva-30-anos-plantando-cara-a-gigantes-como-microsoft-google-apple-asi-planea-seguir-haciendolo-otros-30-anos",
            imageUrl = "https://i.blogs.es/021f43/operadest1/840_560.jpeg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        )
        ,
        NewsItem(
            author = "Javier Lacort",
            title = "Opera lleva 30 años plantando cara a gigantes como Microsoft, Google y Apple. Así planea seguir haciéndolo otros 30 años",
            description = "Hablar de navegadores en la era de TikTok, Instagram, ChatGPT y Netflix quizás suene casi anacrónico, como si se hubiesen convertido en una commodity y lo importante fuese lo que ocurre dentro de su ventana, no en los bordes. Como si se tratase de una guerra …",
            url = "https://www.xataka.com/aplicaciones/opera-lleva-30-anos-plantando-cara-a-gigantes-como-microsoft-google-apple-asi-planea-seguir-haciendolo-otros-30-anos",
            imageUrl = "https://i.blogs.es/021f43/operadest1/840_560.jpeg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        )
        ,
        NewsItem(
            author = "Javier Lacort",
            title = "Opera lleva 30 años plantando cara a gigantes como Microsoft, Google y Apple. Así planea seguir haciéndolo otros 30 años",
            description = "Hablar de navegadores en la era de TikTok, Instagram, ChatGPT y Netflix quizás suene casi anacrónico, como si se hubiesen convertido en una commodity y lo importante fuese lo que ocurre dentro de su ventana, no en los bordes. Como si se tratase de una guerra …",
            url = "https://www.xataka.com/aplicaciones/opera-lleva-30-anos-plantando-cara-a-gigantes-como-microsoft-google-apple-asi-planea-seguir-haciendolo-otros-30-anos",
            imageUrl = "https://i.blogs.es/021f43/operadest1/840_560.jpeg",
            publishedAt = Date.from(Instant.parse("2024-03-31T17:00:00Z"))
        )

    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(news) {
            Row (modifier = Modifier.fillParentMaxHeight(0.25f).padding(0.dp)){
                NewsCard(newsItem = it)
            }
        }

    }
}

enum class TabItem(val title: String) {
    MainTap("Main Tab"),
    SearchTap("Search Tab"),
    FavoriteTap("Favorite Tab")
}