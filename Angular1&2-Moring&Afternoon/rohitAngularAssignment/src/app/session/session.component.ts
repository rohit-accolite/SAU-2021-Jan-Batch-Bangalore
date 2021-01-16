import { Component, OnInit } from '@angular/core';
import { model } from './model';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})
export class SessionComponent implements OnInit {
  newSession: boolean = false;
  sessions: model[] = [];

  inputTitle: String = "";
  inputTrainer: String = "";
  inputDetails: String = "";
  inputDate: String = "";

  constructor() { }

  newSessionAdd() {
    this.newSession = !this.newSession;
  }

  addSession() {
    if(this.inputTitle === "" || this.inputDetails === "" || this.inputTrainer === "" || this.inputDate == ""){
      alert("All fields are required");
      return;
    }
    this.sessions.unshift( {
      name: this.inputTitle,
        details: this.inputDetails,
        trainer: this.inputTrainer,
        date: this.inputDate,
        isVisible: true,
        showDetails: false,
        edit: false
    }) 
  }

  enableEditor(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) session.edit = !session.edit;
      return session;
    })
  }

  editSession(id: number) {
    if(this.inputTitle === "" || this.inputDetails === "" || this.inputTrainer === "" || this.inputDate == ""){
      alert("All fields are required");
      return;
    }
    this.sessions.map((session, index) => {
      if(index == id) {
        session.name = this.inputTitle,
        session.details = this.inputDetails,
        session.trainer = this.inputTrainer,
        session.date = this.inputDate,
        session.isVisible = true,
        session.showDetails = false,
        session.edit = false
      }
      return session;
    })
  }

  deleteSession(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) session.isVisible = false;
      return session;
    })
  }

  showDetails(id: number) {
    this.sessions.map((session, index) => {
      if(index == id) session.showDetails = !session.showDetails;
      return session;
    })
  }

  ngOnInit(): void {

    this.sessions = [
      {
        name: "Angular Session",
        details: "Angular is a platform and framework for building single-page client applications using HTML and TypeScript. Angular is written in TypeScript. It implements core and optional functionality as a set of TypeScript libraries that you import into your apps.",
        trainer: "Sharanya Mahesheka and Pritam Chowdhury",
        date: "2021-01-12",
        isVisible: true,
        showDetails: false,
        edit: false
      },
      {
        name: "React Session",
        details: "React. js is an open-source JavaScript library that is used for building user interfaces specifically for single-page applications. It's used for handling the view layer for web and mobile apps. React also allows us to create reusable UI components. The main purpose of React is to be fast, scalable, and simple.",
        trainer: "Raviteja and Vigneshwar",
        date: "2021-01-13",
        isVisible: true,
        showDetails: false,
        edit: false
      },
      {
        name: "React Native Session",
        details: "React Native is an open-source mobile application framework created by Facebook, Inc. It is used to develop applications for Android, Android TV, iOS, macOS, tvOS, Web, Windows and UWP by enabling developers to use React's framework along with native platform capabilities.",
        trainer: "Tajammul Pasha",
        date: "2021-01-14",
        isVisible: true,
        showDetails: false,
        edit: false
      }
    ]
  }
}