import { Text, type TextProps, StyleSheet } from 'react-native';

import { useThemeColor } from '@/hooks/useThemeColor';

export type ThemedTextProps = TextProps & {
  lightColor?: string;
  darkColor?: string;
  type?: 'default' | 'title' | 'defaultExtraBold' | 'subtitle' | 'link';
};

export function ThemedText({
  style,
  lightColor,
  darkColor,
  type = 'default',
  ...rest
}: ThemedTextProps) {
  const color = useThemeColor({ light: lightColor, dark: darkColor }, 'text');

  return (
    <Text
      style={[
        { color },
        type === 'default' ? styles.default : undefined,
        type === 'title' ? styles.title : undefined,
        type === 'defaultExtraBold' ? styles.defaultExtraBold : undefined,
        type === 'subtitle' ? styles.subtitle : undefined,
        type === 'link' ? styles.link : undefined,
        style,
      ]}
      {...rest}
    />
  );
}

const styles = StyleSheet.create({
  default: {
    fontFamily: 'AlbertSans',
    fontSize: 16,
    lineHeight: 24,
  },
  defaultExtraBold: {
    fontFamily: 'AlbertSans',
    fontSize: 30,
    lineHeight: 24,
    fontWeight: '800'
  },
  title: {
    fontFamily: 'AlbertSans',
    fontSize: 32,
    fontWeight: 'bold',
    lineHeight: 32,
  },
  subtitle: {
    fontFamily: 'AlbertSans',
    fontSize: 20,
    fontWeight: 'bold',
  },
  link: {
    fontFamily: 'AlbertSans',
    lineHeight: 30,
    fontSize: 16,
    color: '#0a7ea4',
  },
});
