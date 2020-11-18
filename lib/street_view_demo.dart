import 'package:flutter/material.dart';
import 'package:flutter_street_view/street_viewer.dart';

class StreetViewDemo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: RaisedButton(
          child: Text("Click to open streetview"),
          onPressed: () {
            StreetViewer.showStreetView("50.0635836395458", "19.94512172576971", "139.26709247816694", "8.931085777681233");
          },
        ),
      ),
    );
  }
}