npm install axios

-- vite.config.ts


import react, { reactCompilerPreset } from '@vitejs/plugin-react'
import babel from '@rolldown/plugin-babel'
import { defineConfig } from 'vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react(),
    babel({ presets: [reactCompilerPreset()] })
  ],
  // 👇 개발 서버 프록시 설정 추가
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // Spring Boot 서버 주소
        changeOrigin: true,             // 대상 서버의 호스트 헤더를 target 주소로 변경
        secure: false                   // https가 아닌 http 환경이므로 false 설정
      }
    }
  }
})
