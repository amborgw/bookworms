import React from "react";
import { StyleSheet } from "react-native";
// import { Button, Image } from "react-native";

export default function LogoButton() {
  const worm = {
    width: '56px',
  }

  return (
    <img src={"../assets/images/worm.png"} alt="Bookworm icon" style={worm}/>
  );
}