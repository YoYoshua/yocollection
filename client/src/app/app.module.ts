import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatMenuModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { GameService } from './shared/game/game.service';
import { GameListComponent } from './game-list/game-list.component';
import { GameEditComponent } from './game-edit/game-edit.component';
import { RouterModule, Routes } from '@angular/router';
import { GameDetailsComponent } from './game-details/game-details.component';
import { GameFormComponent } from './game-form/game-form.component';
import { GameFilterComponent } from './game-filter/game-filter.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/game-list', pathMatch: 'full' },

  {
    path: 'game-list',
    component: GameListComponent
  },

  {
    path: 'game-add',
    component: GameEditComponent
  },

  {
    path: 'game-edit/:id',
    component: GameEditComponent
  },

  {
    path: 'game-details/:id',
    component: GameDetailsComponent
  },

  {
    path: 'game-filter',
    component: GameFilterComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    GameListComponent,
    GameEditComponent,
    GameDetailsComponent,
    GameFormComponent,
    GameFilterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatMenuModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes)

  ],
  providers: [GameService],
  bootstrap: [AppComponent]
})
export class AppModule { }
