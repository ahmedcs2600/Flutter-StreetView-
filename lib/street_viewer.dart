import 'package:flutter/services.dart';

class StreetViewer {
  static const _platform = const MethodChannel('streetView');

  static Future<void> showStreetView(
      String lat, String lng, String heading, String pitch) async {
    final arguments = <String, dynamic>{
      'latitude': lat,
      'longitude': lng,
      'heading': heading,
      'pitch': pitch,
    };
    await _platform.invokeMethod('viewStreetView',arguments);
  }
}
