import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Home",
          style: TextStyle(color: Colors.white),
        ),
        backgroundColor: Colors.amber,
        centerTitle: true,
      ),
      body: Container(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            const Text(
              'Hello, World!',
              style: TextStyle(
                fontSize: 24.0,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
            ),
            const SizedBox(height: 20.0),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                _buildCircle('Flutter', Icons.keyboard, Colors.amber),
                _buildCircle(
                    'Java', Icons.connect_without_contact_sharp, Colors.red),
                _buildCircle(
                    'Spring Boot', Icons.data_array_outlined, Colors.green),
                _buildCircle('MySQL', Icons.list, Colors.blue),
              ],
            ),
            const SizedBox(
              height: 20,
            ),
            const Text(
                "Aplikasi ini terdiri dari CRUD Mahasiswa, Matakuliah, dan Nilai Mahasiswa dengan Back End Service dari Java Spring Boot dan Database MySQL",
                style: TextStyle(
                    color: Colors.black,
                    fontSize: 20,
                    fontWeight: FontWeight.bold),
                textAlign: TextAlign.justify),
          ],
        ),
      ),
    );
  }
}

Widget _buildCircle(String text, IconData icon, Color color) {
  return Column(
    children: [
      Container(
        width: 80.0,
        height: 80.0,
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: color,
        ),
        child: Icon(
          icon,
          size: 40.0,
          color: Colors.black,
        ),
      ),
      const SizedBox(height: 8.0),
      Text(
        text,
        style: const TextStyle(
          color: Colors.black,
          fontSize: 16,
          fontWeight: FontWeight.bold,
        ),
      ),
    ],
  );
}
