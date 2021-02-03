import { Component, OnInit } from '@angular/core';
import { Word } from '../Models/Words';
import { WordService } from '../word.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  editableData!: Word;
  words: Array<Word> = []

  constructor(private wordService: WordService) { 
  }

  ngOnInit(): void {
    this.wordService.getAll().subscribe(words => {
      this.words  = words;
    });
  }

  edit(word:Word): void {
    this.editableData = word;
  }

  delete(word:Word): void {
    this.wordService.deleteWord(word.id).subscribe(res => {
      if(res) {
        this.words = this.words.filter(oldWord => word.id != oldWord.id);
      }
    })
  }

  updateWord($event: any):void{
    // console.log("updateWord")
    console.log($event);

    this.wordService.addWord($event).subscribe(resp => this.words.unshift(resp));
    this.wordService.deleteWord($event.id).subscribe(
      resp => {
        if(resp)
        {
          this.words = this.words.filter(old => old.id != $event.id);  
        } 
      }
    )
  }

  sort(words: Array<Word>): void {
    this.words.sort((a, b) => a.word.localeCompare(b.word));
  }
}
