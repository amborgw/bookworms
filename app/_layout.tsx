import { DarkTheme, DefaultTheme, ThemeProvider } from '@react-navigation/native';
import { useFonts } from 'expo-font';
import { Stack } from 'expo-router';
import * as SplashScreen from 'expo-splash-screen';
import { useEffect } from 'react';
import 'react-native-reanimated';

import { useColorScheme } from '@/hooks/useColorScheme';
import LogoButton from '@/components/LogoButton';
import BookBar from '@/components/BookBar';

// Prevent the splash screen from auto-hiding before asset loading is complete.
SplashScreen.preventAutoHideAsync();

export default function RootLayout() {
  const colorScheme = useColorScheme();
  const [loaded] = useFonts({
    AlbertSans: require('../assets/fonts/AlbertSans-VariableFont_wght.ttf'),
  });

  useEffect(() => {
    if (loaded) {
      SplashScreen.hideAsync();
    }
  }, [loaded]);

  if (!loaded) {
    return null;
  }

  // const handleClick = () => {

  // }

  return (
    <ThemeProvider value={colorScheme === 'dark' ? DarkTheme : DefaultTheme}>
      <Stack
        screenOptions={{
          headerStyle: {
            backgroundColor: '#F8F9FA',
          },
          headerTitleStyle: {
            fontWeight: 'bold',
            fontFamily: 'AlbertSans'
          },
          headerTitle: () => <LogoButton></LogoButton>,
          headerRight: () => <BookBar/>,
          // headerSearchBarOptions: 
        }}
      >
        <Stack.Screen name="Bookworms" />
        <Stack.Screen name="+not-found" />
      </Stack>
    // </ThemeProvider>
  );
}
