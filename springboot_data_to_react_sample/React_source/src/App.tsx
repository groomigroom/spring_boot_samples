import React, { useEffect, useState } from 'react';
import axios from 'axios';

// 1. 데이터 타입 정의
interface ServerData {
  id: number;
  title: string;
  message: string;
}

const App: React.FC = () => {
  // 2. 상태(State) 설정
  const [data, setData] = useState<ServerData | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  // 3. useEffect로 컴포넌트 마운트 시 데이터 요청
  useEffect(() => {
    axios.get<ServerData>('/api/data')
      .then((response) => {
        setData(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error('데이터를 불러오는 중 에러가 발생했습니다:', error);
        setLoading(false);
      });
  }, []);

  if (loading) return <div>로딩 중...</div>;
  if (!data) return <div>데이터가 없습니다.</div>;

  // 4. 화면에 출력
  return (
    <div>
      <h1>{data.title}</h1>
      <p>ID: {data.id}</p>
      <p>내용: {data.message}</p>
    </div>
  );
};

export default App;
