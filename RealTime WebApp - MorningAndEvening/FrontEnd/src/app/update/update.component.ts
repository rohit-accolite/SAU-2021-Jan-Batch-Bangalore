import { DatePipe } from '@angular/common';
import { Component, Input, OnInit, Output, SimpleChanges, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Word } from '../Models/Words';
import { WordService } from '../word.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  @Input ('action') buttonlabel: any;
  @Input('editableData') editableData: any;
  @Output() updateWord = new EventEmitter();
  wordForm!: FormGroup;
  addWordPayload!: Word;

  constructor(private wordService: WordService) {
    
   }

  ngOnInit(): void {
    this.wordForm = new FormGroup({
      word : new FormControl("", [Validators.required, Validators.minLength(2), Validators.maxLength(50)]),
      meaning : new FormControl("", [Validators.required, Validators.minLength(10), Validators.maxLength(150)]),
      partOfSpeech : new FormControl("", [Validators.required]),
      example : new FormControl("", [Validators.required]),
    });
  }

  // addWord(): void {
  //   this.addWordPayload = this.wordForm.value;
  //   this.wordService.addWord(this.addWordPayload).subscribe(resp => {
  //     console.log(resp);
  //   })
  // }

  changed(): void {

  }

  addOrUpdateWord(): void {
    // console.log("addOrUpdate")
    if(this.buttonlabel.includes("Update"))
    {
      this.updateWord.emit({
        ...this.wordForm.value,
        id:this.editableData.id
      })
    }
    else
    {
      this.addWordPayload = this.wordForm.value;
      this.wordService.addWord(this.addWordPayload).subscribe(resp => console.log(resp));
    }

  }

  ngOnChanges(changes: any) {
    if(changes.editableData && changes.editableData.currentValue != changes.editableData.previousValue) {
      console.log(changes.editableData);
      let tempWord = {
        word: this.editableData.word,
        meaning: this.editableData.meaning,
        partOfSpeech: this.editableData.partOfSpeech,
        example: this.editableData.example
      }
      this.wordForm.setValue(tempWord);
    }
  }

}
