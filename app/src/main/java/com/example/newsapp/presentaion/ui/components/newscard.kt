package com.example.newsapp.presentaion.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.newsapp.domain.NewsItem

@Composable
fun NewsCard(newsItem: NewsItem) {
    //
    Card(
        modifier = Modifier
//            .fillMaxWidth()
            .fillMaxSize()
            .padding(horizontal = 4.dp)
        ,
        shape = RoundedCornerShape(2.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    )
    {
        Column(modifier = Modifier
            .padding( 8.dp)) {
            Row(modifier = Modifier.fillMaxHeight(0.2f)) {
                Text(
                    text = newsItem.title,
                    maxLines = 1,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .basicMarquee()
                        .padding(4.dp)
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.6f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .padding(4.dp)
                                .animateContentSize(),
                            model = newsItem.imageUrl,
                            contentDescription = null,
                            alignment = Alignment.Center,
                            contentScale = ContentScale.FillBounds,
                            clipToBounds = false
                        ) {
                            val state = painter.state
                            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                CircularProgressIndicator()
                            } else {
                                SubcomposeAsyncImageContent(modifier = Modifier.fillMaxSize())
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                        , horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        AnimatedVisibility(visible = !newsItem.author.isNullOrEmpty()) {
                            Text(text = newsItem.author.toString(), modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.bodyMedium)
                        }
                        Text(text = newsItem.publishedAt.toString(), style = MaterialTheme.typography.bodySmall)

                    }

                }
                Column(
                ) {

                    Text(
                        text = newsItem.description,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }

        }

    }
}