import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.tenderapp.tender.TenderViewModel
import com.android.tenderapp.ui.TenderUiState
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun TenderScreen(viewModel: TenderViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    when (state) {
        is TenderUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is TenderUiState.Success -> {
            val tenders = (state as TenderUiState.Success).tenders

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(tenders) { tender ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Title: ${tender.title}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Date: ${tender.date}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Category: ${tender.category}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Suppliers: ${tender.awarded.firstOrNull()?.suppliers?.joinToString { it.name } ?: "N/A"}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Divider(modifier = Modifier.padding(top = 12.dp))
                    }
                }
            }
        }

        is TenderUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = (state as TenderUiState.Error).message,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
