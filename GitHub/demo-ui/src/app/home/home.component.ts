import { Component, OnInit } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { DemoDTO } from '../interfaces/demo-dto';
import { from } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // Set when response is ok
  getOK: boolean = undefined;
  putOK: boolean = undefined;
  postOK: boolean = undefined;

  // Displayed response
  getBody: any = undefined;
  putBody: any = undefined;
  postBody: any = undefined;

  // Set if Form-Fields are valid
  postValid: boolean;
  putValid: boolean;

  // Form Group where request-data is set
  form: FormGroup;


  constructor(private backendService: BackendService, fb: FormBuilder) {
    this.form = fb.group({ // Form-Group
      postText: new FormControl('' , [Validators.minLength(1)]), // Post text-input
      putId: new FormControl('' , [Validators.minLength(1)]), // Put ID-input
      putText: new FormControl('', [Validators.minLength(1)]) // Put text-input
    });
    this.postValid = false;
    this.putValid = false;
   }

  ngOnInit() {
    this.form.controls['postText'].valueChanges.pipe()
      .subscribe(v => {
        // When value inside form-field changes...
        this.postValid = this.form.controls['postText'].valid;
      });
    this.form.controls['putId'].valueChanges.pipe()
      .subscribe(v => {
        // When value inside form-field changes...
        this.putValid = this.form.controls['putId'].valid && this.form.controls['putText'].valid;
      });
    this.form.controls['putText'].valueChanges.pipe()
      .subscribe(v => {
        // When value inside form-field changes...
        this.putValid = this.form.controls['putId'].valid && this.form.controls['putText'].valid;
      });
  }

  public get() {
    // Do GET-Request
    this.backendService.get().then(res => {
      // When response arrives
      this.getBody = res;
      this.getOK = true;
    }).catch((ex: HttpErrorResponse) => {
      if (ex.status === 200) {
        this.getOK = true;
      } else {
        this.getOK = false;
      }
    });
  }

  public put() {
    // Create Object which will be send to backend (service)
    const demo1: DemoDTO = {
      id: this.form.controls['putId'].value,
      sampleText: this.form.controls['putText'].value
    };

    // Do PUT-Request
    this.backendService.put(demo1).then(res => {
      // When response arrives
      this.putOK = true;
      this.putBody = res;
    }).catch((ex: HttpErrorResponse) => {
      if (ex.status === 200) {
        this.putOK = true;
      } else {
        this.putOK = false;
      }
    });
  }

  public post() {
    // Create Object which will be send to backend (service)
    const demo: DemoDTO = {
      id: null, // ID will be generated from backend
      sampleText: this.form.controls['postText'].value
    };

    // Do POST-Request
    this.backendService.post(demo).then(res => {
      // When response arrives
      this.postOK = true;
      this.postBody = res;
    }).catch((ex: HttpErrorResponse) => {
      if (ex.status === 200) {
        this.postOK = true;
      } else {
        this.postOK = false;
      }
    });
  }

}
