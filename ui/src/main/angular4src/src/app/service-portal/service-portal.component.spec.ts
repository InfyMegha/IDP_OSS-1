/**
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.”
*
**/
import { async, ComponentFixture, TestBed } from "@angular/core/testing";
import { ServicePortalComponent } from "./service-portal.component";

describe("ServicePortalComponent", () => {
  let component: ServicePortalComponent;
  let fixture: ComponentFixture<ServicePortalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
        declarations: [ ServicePortalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicePortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
